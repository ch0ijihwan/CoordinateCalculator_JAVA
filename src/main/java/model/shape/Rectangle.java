package model.shape;

import model.point.Coordinate;
import model.point.Point;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Rectangle implements Shape {
    private static final int NUMBER_OF_DUPLICATED_COORDINATE = 2;
    private static final int NUMBER_OF_RECTANGULAR_VERTEX = 4;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private final List<Point> points;

    public Rectangle(List<Point> points) {
        validateNumberOfPoints(points);
        validateDuplication(points);
        validateRectangularShape(points);
        this.points = points;
    }

    private void validateNumberOfPoints(List<Point> points) {
        if (points.size() != NUMBER_OF_RECTANGULAR_VERTEX) {
            throw new IllegalArgumentException("사각형을 만들기 위해서는 점이 4개 만이 필요합니다.");
        }
    }

    private void validateDuplication(List<Point> points) {
        if (points.stream().distinct().count() != NUMBER_OF_RECTANGULAR_VERTEX) {
            throw new IllegalArgumentException("사각형을 만들기 위해서는 서로 다른 점 4개가 필요합니다.");
        }
    }

    private void validateRectangularShape(List<Point> points) {
        Set<Coordinate> duplicationRemovedXCoordinates = removeCoordinateDuplication(points, Point::getX);
        Set<Coordinate> duplicationRemovedYCoordinates = removeCoordinateDuplication(points, Point::getY);

        if (isNotDuplicated(duplicationRemovedXCoordinates) && isNotDuplicated(duplicationRemovedYCoordinates)) {
            throw new IllegalArgumentException("입력받은 점들이 직사각형의 형태가 아닙니다.");
        }
    }

    private Set<Coordinate> removeCoordinateDuplication(List<Point> points, Function<Point, Coordinate> function) {
        return points.stream()
                .map(function)
                .collect(Collectors.toUnmodifiableSet());
    }

    private boolean isNotDuplicated(Set<Coordinate> duplicationRemovedCoordinates) {
        return duplicationRemovedCoordinates.size() != NUMBER_OF_DUPLICATED_COORDINATE;
    }

    @Override
    public double getArea() {
        List<Coordinate> duplicationRemovedXCoordinates = removeCoordinateDuplication(points, Point::getX).stream()
                .collect(Collectors.toUnmodifiableList());
        List<Coordinate> duplicationRemovedYCoordinates = removeCoordinateDuplication(points, Point::getY).stream()
                .collect(Collectors.toUnmodifiableList());

        return getLengthOfSide(duplicationRemovedXCoordinates) * getLengthOfSide(duplicationRemovedYCoordinates);
    }

    private double getLengthOfSide(List<Coordinate> coordinates) {
        return Math.abs(coordinates.get(FIRST_INDEX).getDistanceOfCoordinates(coordinates.get(SECOND_INDEX)));
    }

    @Override
    public String getShapeType() {
        return "사각형";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(points, rectangle.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "points=" + points +
                '}';
    }
}