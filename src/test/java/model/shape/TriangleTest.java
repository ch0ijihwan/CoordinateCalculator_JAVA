package model.shape;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.offset;

class TriangleTest {
    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력 받은 좌표를 리스트 형태로 가진다.")
    void createTriangle() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 0), new Point(1, 1));

        //when
        Triangle triangle = new Triangle(inputtedPoints);

        //then
        assertThat(triangle).isEqualTo(new Triangle(inputtedPoints));
    }

    @Test
    @DisplayName("객체 생성 시, validateNumberOfPoints 를 호출하여 파라미터로 부터 입력 받은 좌표의 개수가 3개를 초과하면 예외처리를 반환한다.")
    void validateNumberOfPoints() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 0), new Point(1, 0), new Point(1, 1));

        //then
        assertThatThrownBy(() -> new Triangle(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 만들기 위해서는 점이 3개 만이 필요합니다.");
    }

    @Test
    @DisplayName("객체 생성 시,validateDuplication() 를 호출하여 파라미터로 부터 입력받은 점들 중 같은 점이 있는 경우 예외 처리를 반환한다.")
    void validateDuplication() {
        //given
        List<Point> inputtedPoints = List.of(new Point(1, 1), new Point(1, 1), new Point(2, 2));

        //then
        assertThatThrownBy(() -> new Triangle(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 만들기 위해서는 서로 다른 점 3개가 필요합니다.");
    }

    @Test
    @DisplayName("getArea() 호출 시, 삼각형의 면적를 반환한다.")
    void getLength() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 0), new Point(1, 1));
        Triangle triangle = new Triangle(inputtedPoints);

        //when
        double actual = triangle.getArea();

        //then
        assertThat(actual).isEqualTo(0.5, offset(0.00099));
    }
}