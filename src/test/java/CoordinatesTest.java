import model.Coordinates;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import model.vo.Coordinate;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CoordinatesTest {
    Coordinates coordinates;

    @Test
    @DisplayName("X값들과 Y값들을 가진 두개의 배열 입력시, 좌표 객체를 만들어 리스트화한다.")
    void creatCoordinates() {
        //given
        int[] Xs = new int[]{1, 2, 3};
        int[] Ys = new int[]{5, 6, 7};
        coordinates = new Coordinates(Xs, Ys);
        List<Coordinate> expectCoordinates = Arrays.asList(new Coordinate(1, 5), new Coordinate(2, 6), new Coordinate(3, 7));

        //when
        List<Coordinate> actual = coordinates.getCoordinates();

        //then
        assertThat(actual).isEqualTo(expectCoordinates);
    }
}
