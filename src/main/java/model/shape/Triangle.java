package model.shape;

import model.point.Point;

import java.util.List;
import java.util.Objects;

public class Triangle implements Shape {
    private static final int NUMBER_OF_TRIANGLE_VERTEX = 3;
    private final List<Point> points;

    public Triangle(List<Point> points) {
        validateNumberOfPoints(points);
        validateDuplication(points);
        this.points = points;
    }

    private void validateNumberOfPoints(List<Point> points) {
        if (points.size() != NUMBER_OF_TRIANGLE_VERTEX) {
            throw new IllegalArgumentException("삼각형을 만들기 위해서는 점이 3개 만이 필요합니다.");
        }
    }

    private void validateDuplication(List<Point> points) {
        if (points.stream().distinct().count() != NUMBER_OF_TRIANGLE_VERTEX) {
            throw new IllegalArgumentException("삼각형을 만들기 위해서는 서로 다른 점 3개가 필요합니다.");
        }
    }

    @Override
    public double getArea() {
        Point xPoint = points.get(0);
        Point yPoint = points.get(1);
        Point zPoint = points.get(2);

        return 0.5 * Math.abs(
                xPoint.getX().getValue() * yPoint.getY().getValue()
                        + yPoint.getX().getValue() * zPoint.getY().getValue()
                        + zPoint.getX().getValue() * xPoint.getY().getValue()
                        - (
                        xPoint.getY().getValue() * yPoint.getX().getValue()
                                + yPoint.getY().getValue() * zPoint.getX().getValue()
                                + zPoint.getY().getValue() * xPoint.getX().getValue())
        );
    }

    @Override
    public String getShapeType() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + points +
                '}';
    }
}
