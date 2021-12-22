package model;

import model.point.Point;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Validator {
    private static final char CHAR_BAR = '-';
    private static final char DELIMITER_SPOT = ',';
    private static final int NO_INPUTTED_BAR = 0;
    private static final int INPUTTED_ONLY_ONE_POINT = 0;
    private static final String DELIMITER_BAR = "-";
    private static final String POINT_REGX = "\\([0-9]{1,2},[0-9]{1,2}\\)";
    private static final String DUPLICATION_BAR_REGX = "-{2,}";
    private static final Pattern POINT_PATTERN = Pattern.compile(POINT_REGX);
    private final List<Point> points;

    public Validator(String inputtedValue) {
        validateExpressionForm(inputtedValue);
        List<String> inputtedPoints = divideValuesByBar(inputtedValue);
        validatePointForm(inputtedPoints);
        points = inputtedPoints.stream().map(this::createPoint).collect(Collectors.toUnmodifiableList());
    }

    private List<String> divideValuesByBar(String inputtedValue) {
        return Arrays.stream(inputtedValue.split(DELIMITER_BAR)).collect(Collectors.toUnmodifiableList());
    }

    private void validateExpressionForm(String values) {
        validateBarDuplication(values);
        int numberOfBars = countChar(values, CHAR_BAR);
        int numberOfPoints = divideValuesByBar(values).size();

        if (numberOfBars == NO_INPUTTED_BAR || numberOfPoints == INPUTTED_ONLY_ONE_POINT || numberOfBars + 1 != numberOfPoints) {
            throw new IllegalArgumentException("입력 받은 좌표식의 형태가 이상합니다.");
        }

    }

    private void validateBarDuplication(String values) {
        int removedDuplicationValueSize = values.replaceAll(DUPLICATION_BAR_REGX, "").length();
        if (removedDuplicationValueSize != values.length()) {
            throw new IllegalArgumentException("입력 받은 좌표식의 형태가 이상합니다.");
        }
    }

    private int countChar(String values, char target) {
        return (int) values.chars().filter(c -> c == target).count();
    }


    private void validatePointForm(List<String> inputtedPoints) {
        int invalidPointFormCount = (int) inputtedPoints.stream().filter(value -> !POINT_PATTERN.matcher(value).matches()).count();

        if (invalidPointFormCount > 0) {
            throw new IllegalArgumentException("입력 받은 좌표 중, 형태가 이상한 것이 있습니다.");
        }
    }

    private Point createPoint(String pointValue) {
        String removedBracketValue = pointValue.substring(1, pointValue.length() - 1);
        int indexOfSpot = pointValue.indexOf(DELIMITER_SPOT);
        int x = Integer.parseInt(removedBracketValue.substring(0, indexOfSpot - 1));
        int y = Integer.parseInt(removedBracketValue.substring(indexOfSpot));

        return new Point(x, y);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Validator validator = (Validator) o;
        return Objects.equals(points, validator.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }

    @Override
    public String toString() {
        return "Validator{" +
                "points=" + points +
                '}';
    }
}
