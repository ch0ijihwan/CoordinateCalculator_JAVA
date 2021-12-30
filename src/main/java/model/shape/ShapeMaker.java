package model.shape;

import model.point.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ShapeMaker {
    private static final int NUMBER_OF_POINTS_FOR_LINE = 2;
    private static final int NUMBER_OF_POINTS_FOR_TRIANGLE = 3;
    private static final int NUMBER_OF_POINTS_FOR_RECTANGLE = 4;
    private static final Map<Integer, Function<List<Point>, Shape>> shapeMap = new HashMap<>();

    private ShapeMaker() {
    }

    static {
        shapeMap.put(NUMBER_OF_POINTS_FOR_LINE, StraightLine::new);
        shapeMap.put(NUMBER_OF_POINTS_FOR_TRIANGLE, Triangle::new);
        shapeMap.put(NUMBER_OF_POINTS_FOR_RECTANGLE, Rectangle::new);
    }

    public static Shape makeShape(List<Point> points) {
        int numberOfPoints = points.size();
        return shapeMap.get(numberOfPoints).apply(points);
    }
}
