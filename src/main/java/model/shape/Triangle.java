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

        return findAreaOfThreeCoordinates(xPoint,yPoint,zPoint);
    }

    private double findAreaOfThreeCoordinates(Point x, Point y, Point z) {
        int x1 = x.getXValue();
        int x2 = y.getXValue();
        int x3 = z.getXValue();
        int y1 = x.getYValue();
        int y2 = y.getYValue();
        int y3 = z.getYValue();
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - (y1 * x2 + y2 * x3 + y3 * x1));
    }

    @Override
    public String getShapeType() {
        return "삼각형";
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
