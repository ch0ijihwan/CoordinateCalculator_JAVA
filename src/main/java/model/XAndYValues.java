package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class XAndYValues {
    private int[] Xs;
    private int[] Ys;

    public XAndYValues(List<String> coordinateTokens) {
        int coordinateSize = coordinateTokens.size();
        Xs = new int[coordinateSize];
        Ys = new int[coordinateSize];

        divideXAndY(removeBrackets(coordinateTokens));
    }

    private List<String> removeBrackets(List<String> tokens) {
        List<String> removedBrackets = new ArrayList<>();
        tokens.forEach(token -> removedBrackets.add(token.substring(1, token.length() - 1)));

        return removedBrackets;
    }

    private void divideXAndY(List<String> removedBrackets) {
        IntStream.range(0, removedBrackets.size())
                .forEach(index -> Xs[index] = Integer.parseInt(removedBrackets.get(index).split(",")[0]));
        IntStream.range(0, removedBrackets.size())
                .forEach(index -> Ys[index] = Integer.parseInt(removedBrackets.get(index).split(",")[1]));
    }

    public int[] getXs() {
        return Xs;
    }

    public int[] getYs() {
        return Ys;
    }
}
