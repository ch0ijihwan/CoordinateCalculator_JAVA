package model;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ExpressionFormValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"(10,10)(14,15)", "(10,10)--(20,8)"})
    @DisplayName("객체 생성 시 파라미터로 부터 입력 받은 좌표식의 형태가 유효하지 않은 경우 예외처리를 반환한다.")
    void validateExpressionShape(String inputtedValue) {
        //then
        assertThatThrownBy(() -> new ExpressionFormValidator(inputtedValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 받은 좌표식의 형태가 이상합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"(1,1(-(1,1)", ")1,1)-(1,1)", "1,1-(1,2)"}, delimiter = ' ')
    @DisplayName("객체 생성 시 파라미터로 부터 입력 받은 좌표 중, 괄호의 형태가 유효하지 않은 경우 예외처리를 반환한다.")
    void validateCoordinateForm(String inputtedValue) {
        //then
        assertThatThrownBy(() -> new ExpressionFormValidator(inputtedValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 받은 좌표 중, 형태가 이상한 것이 있습니다.");
    }

    @Test
    @DisplayName("getPoints() 호출 시, 입력 받은 좌표식의 좌표들을 반환한다.")
    void getPoints() {
        //given
        String inputted = "(10,10)-(14,15)-(20,8)";
        ExpressionFormValidator expressionFormValidator = new ExpressionFormValidator(inputted);
        List<Point> expectedPoints = List.of(new Point(10, 10), new Point(14, 15), new Point(20, 8));

        //when
        List<Point> actual = expressionFormValidator.getPoints();

        //then
        assertThat(actual).isEqualTo(expectedPoints);
    }
}
