package model.shape;

import model.point.Point;

import java.util.List;
import java.util.Objects;

public class StraightLine implements Shape {
    private static final int FIRST_POINT = 0;
    private static final int SECOND_POINT = 1;
    private static final int NUMBER_OF_LINE_VERTEX = 2;
    private final List<Point> points;

    public StraightLine(List<Point> points) {
        validateNumberOfPoints(points);
        validateDuplication(points);
        this.points = points;
    }

    private void validateNumberOfPoints(List<Point> points) {
        if (points.size() != NUMBER_OF_LINE_VERTEX) {
            throw new IllegalArgumentException("선을 만들기 위해서는 점이 2개 만이 필요합니다.");
        }
    }

    private void validateDuplication(List<Point> points) {
        if (points.stream().distinct().count() != NUMBER_OF_LINE_VERTEX) {
            throw new IllegalArgumentException("선을 만들기 위해서는 서로 다른 점 2개가 필요합니다.");
        }
    }

    public double getLength() {
        return points.get(FIRST_POINT).measureDistance(points.get(SECOND_POINT));
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public String getShapeType() {
        return "StraightLine";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StraightLine that = (StraightLine) o;
        return Objects.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
