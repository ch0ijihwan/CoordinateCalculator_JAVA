package model.shape;

import model.point.Point;

import java.util.List;
import java.util.Objects;

public class StraightLine implements Shape {
    private static final int FIRST_POINT_INDEX = 0;
    private static final int SECOND_POINT_INDEX = 1;
    private static final int NUMBER_OF_VERTEX = 2;
    private final List<Point> points;

    public StraightLine(List<Point> points) {
        validateNumberOfPoints(points);
        validateDuplication(points);
        this.points = points;
    }

    private void validateNumberOfPoints(List<Point> points) {
        if (points.size() != NUMBER_OF_VERTEX) {
            throw new IllegalArgumentException("선을 만들기 위해서는 점이 2개 만이 필요합니다.");
        }
    }

    private void validateDuplication(List<Point> points) {
        if (points.stream().distinct().count() != NUMBER_OF_VERTEX) {
            throw new IllegalArgumentException("선을 만들기 위해서는 점이 중복되면 안됩니다.");
        }
    }

    private double getLength() {
        return points.get(FIRST_POINT_INDEX)
                .measureDistance(points.get(SECOND_POINT_INDEX));
    }

    @Override
    public double getArea() {
        return getLength();
    }

    @Override
    public String getShapeType() {
        return "직선";
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

    @Override
    public String toString() {
        return "StraightLine{" +
                "points=" + points +
                '}';
    }
}
