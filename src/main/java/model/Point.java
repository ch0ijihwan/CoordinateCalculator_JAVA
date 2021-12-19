package model;

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

    public double measureDistance(Point anotherPoint) {
        double x1 = getX().getValue();
        double x2 = anotherPoint.getX().getValue();
        double y1 = getY().getValue();
        double y2 = anotherPoint.getX().getValue();
        double xDistance = Math.pow(x1 - x2, 2);
        double yDistance = Math.pow(y1 - y2, 2);
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
