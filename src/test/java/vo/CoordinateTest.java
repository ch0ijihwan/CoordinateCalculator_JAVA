package vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CoordinateTest {
    private Coordinate coordinate;

    @Test
    @DisplayName("객체 생성시 입력 받은 좌표의 x의 값을 반환한다.")
    void getX() {
        //given
        coordinate = new Coordinate(1, 2);
        int expect = 1;

        //when
        int actual = coordinate.getX();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("객체 생성시 입력 받은 좌표의 y의 값을 반환한다.")
    void getY() {
        //given
        coordinate = new Coordinate(1, 2);
        int expect = 2;

        //when
        int actual = coordinate.getY();

        //then
        assertThat(actual).isEqualTo(expect);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2", "0,0", "10,20", "-1,-1"})
    @DisplayName("하나의 문자열로 숫자 두개를 받았을 때, 그중 첫번째로 입력받은 수를 x로" +
            "두번째로 입력받은 수를 y로 좌표 형태로 저장하는지 확인한다.")
    void createCoorinate(String inputX, String inputY) {
        //given
        int x = Integer.parseInt(inputX);
        int y = Integer.parseInt(inputY);
        int expectX = x;
        int expectY = y;

        //when
        coordinate = new Coordinate(x, y);

        //then
        assertAll(
                () -> assertThat(coordinate.getX()).isEqualTo(expectX),
                () -> assertThat(coordinate.getY()).isEqualTo(expectY)
        );
    }

    @Test
    @DisplayName("두 좌표 객체를 비교하여 x값과 y값이 각각 같은 경우 true를 반환")
    void equals() {
        //given
        Coordinate otherCoordinate = new Coordinate(1, 1);
        coordinate = new Coordinate(1, 1);

        //when
        boolean actual = coordinate.equals(otherCoordinate);

        //then
        assertThat(actual).isTrue();
    }
}
