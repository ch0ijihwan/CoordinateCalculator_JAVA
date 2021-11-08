import vo.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Coordinates {
    private List<Coordinate> coordinates = new ArrayList<>();

    public Coordinates(int[] Xs, int[] Ys) {
        IntStream.range(0, Xs.length)
                .forEach(index -> coordinates.add(new Coordinate(Xs[index], Ys[index])));
    }

    public List<Coordinate> getCoordinates(){
        return coordinates;
    }
}
