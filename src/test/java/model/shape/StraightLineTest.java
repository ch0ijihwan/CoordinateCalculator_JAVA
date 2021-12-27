package model.shape;

import model.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.offset;


class StraightLineTest {
    private static final double ROOT_2 = 1.414;

    @Test
    @DisplayName("객체 생성 시, 파라미터로 부터 입력 받은 좌표를 리스트 형태로 가진다.")
    void createLine() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 1));

        //when
        StraightLine straightLine = new StraightLine(inputtedPoints);

        //then
        assertThat(straightLine).isEqualTo(new StraightLine(inputtedPoints));
    }

    @Test
    @DisplayName("객체 생성 시, validateNumberOfPoints 를 호출하여 파라미터로 부터 입력 받은 좌표의 개수가 2개를 초과하면 예외처리를 반환한다.")
    void validateNumberOfPoints() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 1), new Point(2, 2));

        //then
        assertThatThrownBy(() -> new StraightLine(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("선을 만들기 위해서는 점이 2개 만이 필요합니다.");
    }

    @Test
    @DisplayName("객체 생성 시,validateDuplication() 를 호출하여 파라이머톨 부터 입력받은 점 두 가지가 같은 경우 예외 처리를 반환한다.")
    void validateDuplication() {
        //given
        List<Point> inputtedPoints = List.of(new Point(1, 1), new Point(1, 1));

        //then
        assertThatThrownBy(() -> new StraightLine(inputtedPoints))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("선을 만들기 위해서는 서로 다른 점 2개가 필요합니다.");
    }

    @Test
    @DisplayName("getLength() 호출 시, 선의 길이를 반환한다.")
    void getLength() {
        //given
        List<Point> inputtedPoints = List.of(new Point(0, 0), new Point(1, 1));
        StraightLine straightLine = new StraightLine(inputtedPoints);

        //when
        double actual = straightLine.getArea();

        //then
        assertThat(actual).isEqualTo(ROOT_2, offset(0.00099));
    }
}