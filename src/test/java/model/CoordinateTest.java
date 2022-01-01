package model;

import model.point.Coordinate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateTest {
    @Test
    @DisplayName("객체 생성 시, 생성자로 부터 차례대로 입력 받은 값을 좌표로 저장한다.")
    void createCoordinate() {
        //given
        int inputtedCoordinate = 1;

        //when
        Coordinate coordinate = new Coordinate(inputtedCoordinate);

        //then
        assertThat(coordinate).isEqualTo(new Coordinate(inputtedCoordinate));
    }

    @ParameterizedTest
    @DisplayName("객체 생성 시, 생성자로부터 입력받은 좌표의 값이 0 보다 작거나 24 보다 크면, 예외처리를 반환한다.")
    @ValueSource(ints = {-1, 25})
    void validateCoordinate(int inputtedCoordinate) {
        //then
        assertThatThrownBy(() -> new Coordinate(inputtedCoordinate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표의 값은 0 ~ 24 사이의 값 이어야 합니다.");
    }

    @Test
    @DisplayName("getValue() 호출 시, 값을 반환한다.")
    void getValue() {
        //given
        int inputtedValue = 1;
        int expectedValue = 1;
        Coordinate coordinate = new Coordinate(inputtedValue);

        //when
        int actual = coordinate.getValue();

        //then
        assertThat(actual).isEqualTo(expectedValue);
    }
}
