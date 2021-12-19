package model;

import java.util.Objects;

public class Coordinate {
    private static final int MIN_BOUNDARY = 0;
    private static final int MAX_BOUNDARY = 24;
    private static final String INVALID_COORDINATE_BOUNDARY_MESSAGE = "좌표의 값은 0 ~ 24 사이의 값 이어야 합니다.";

    private final int value;

    public Coordinate(int value) {
        validateCoordinate(value);
        this.value = value;
    }

    private void validateCoordinate(int value) {
        if (value < MIN_BOUNDARY || value > MAX_BOUNDARY) {
            throw new IllegalArgumentException(INVALID_COORDINATE_BOUNDARY_MESSAGE);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "value=" + value +
                '}';
    }
}
