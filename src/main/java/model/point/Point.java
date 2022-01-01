package model.point;

import java.util.Objects;

public class Point {
    private final Coordinate x;
    private final Coordinate y;

    public Point(int x, int y) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
    }

    public Coordinate getX() {
        return x;
    }

    public Coordinate getY() {
        return y;
    }

    public int getXValue() {
        return x.getValue();
    }

    public int getYValue() {
        return y.getValue();
    }

    public double measureDistance(Point anotherPoint) {
        Coordinate anotherX = anotherPoint.getX();
        Coordinate anotherY = anotherPoint.getY();
        double xDistance = Math.pow((double) x.getValue() - (double) anotherX.getValue(), 2);
        double yDistance = Math.pow((double) y.getValue() - (double) anotherY.getValue(), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
