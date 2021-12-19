package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CoordinateTest {
    @ParameterizedTest
    @DisplayName("객체 생성 시, 좌표의 값을 입력 받으면 이를 저장한다.")
    @CsvSource(value = {"0", "24"})
    void createCoordinate(int inputtedCoordinate) {
        //when
        Coordinate coordinate = new Coordinate(inputtedCoordinate);

        //then
        assertThat(coordinate).isEqualTo(new Coordinate(inputtedCoordinate));
    }

    @ParameterizedTest
    @DisplayName("입력 받은 좌표의 값이 0 보다 작거나 24 보다 크면, 예외처리를 반환한다.")
    @CsvSource(value = {"-1", "25"})
    void validateCoordinate(int inputtedCoordinate) {
        //then
        assertThatThrownBy(() -> new Coordinate(inputtedCoordinate))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표의 값은 0 ~ 24 사이의 값 이어야 합니다.");
    }
}