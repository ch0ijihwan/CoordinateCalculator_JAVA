package model.shape;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ShapeMakerTest {

    @Test
    @DisplayName("Point 를 2개 입력 받으면 StraightLine 객체를 생성한다.")
    void createStraightLine() {
        //given
        List<Point> points = List.of(new Point(0, 0), new Point(0, 1));

        //when
        Shape actual = ShapeMaker.makeShape(points);

        //then
        assertThat(actual).isEqualTo(new StraightLine(points));
    }
    
    @Test
    @DisplayName("Point 를 3개 입력 받으면 Triangle 객체를 생성한다.")
    void createTriangle() {
        //given
        List<Point> points = List.of(new Point(0, 0), new Point(0, 1), new Point(1, 1));

        //when
        Shape actual = ShapeMaker.makeShape(points);

        //then
        assertThat(actual).isEqualTo(new Triangle(points));

    }

    @Test
    @DisplayName("Point 를 4개 입력 받으면 Rectangle 객체를 생성한다.")
    void createRectangle() {
        //given
        List<Point> points = List.of(new Point(0, 0), new Point(0, 1), new Point(1, 1), new Point(1,0));

        //when
        Shape actual = ShapeMaker.makeShape(points);

        //then
        assertThat(actual).isEqualTo(new Rectangle(points));
    }
}