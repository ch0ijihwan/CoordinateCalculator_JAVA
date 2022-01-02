package model.shape;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RectangleTest {
    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력 받은 좌표를 리스트 형태로 가진다.")
    void createRectangle() {
        //given
        List<Point> inputtedPoints =
                List.of(new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1));

        //when
        Rectangle rectangle = new Rectangle(inputtedPoints);

        //then
        assertThat(rectangle).isEqualTo(new Rectangle(inputtedPoints));
    }

    @Test
    @DisplayName("객체 생성 시, validateNumberOfPoints 를 호출하여 파라미터로 부터 입력 받은 좌표의 개수가 4개가 아니라면 예외처리를 반환한다.")
    void validateNumberOfPoints() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0));

        //then
        assertThatThrownBy(() -> new Rectangle(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형을 만들기 위해서는 점이 4개 만이 필요합니다.");
    }

    @Test
    @DisplayName("객체 생성 시,validateDuplication() 를 호출하여 파라미터로 부터 입력받은 점들이 중복되는 경우이 있는 경우 예외 처리를 반환한다.")
    void validateDuplication() {
        //given
        List<Point> inputtedPoints = List.of(new Point(1, 1), new Point(1, 1), new Point(2, 2), new Point(3, 3));

        //then
        assertThatThrownBy(() -> new Rectangle(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사각형을 만들기 위해서는 서로 다른 점 4개가 필요합니다.");
    }

    @ParameterizedTest
    @MethodSource("NotRectangularShapePointsProvider")
    @DisplayName("객체 생성 시, validateRectangularShape() 을 호출하여 " +
            "파라미터로 부터 입력받은 점들이 직사각형의 형태를 띄는지 확인하고, 그렇지 않은 경우 예외처리를 반환한다.")
    void validateRectangularShape(List<Point> points) {
        //then
        assertThatThrownBy(() -> new Rectangle(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력받은 점들이 직사각형의 형태가 아닙니다.");
    }

    static Stream<Arguments> NotRectangularShapePointsProvider() {
        return Stream.of(
                arguments(
                        asList(
                                new Point(0, 0), new Point(2, 0),
                                new Point(3, 0), new Point(4, 0)
                        ),
                        asList(
                                new Point(1, 0), new Point(2, 0),
                                new Point(0, 1), new Point(2, 1)
                        ),
                        asList(
                                new Point(1, 1), new Point(2, 1),
                                new Point(0, 0), new Point(1, 0)
                        ),
                        asList(
                                new Point(2, 2), new Point(4, 1),
                                new Point(2, 0), new Point(0, 1)
                        )
                )
        );
    }

    @Test
    @DisplayName("getArea() 호출 시, 사각형의 면적를 반환한다.")
    void getLength() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 0), new Point(0, 1), new Point(1, 1));
        Rectangle rectangle = new Rectangle(inputtedPoints);

        //when
        double actual = rectangle.getArea();

        //then
        assertThat(actual).isEqualTo(1.0, offset(0.00099));
    }
}