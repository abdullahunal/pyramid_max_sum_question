package org.example.pyramid;

import org.example.pyramid.brick.Brick;
import org.example.pyramid.brick.Index;

import java.util.ArrayList;
import java.util.List;

public final class PyramidFactory {

    private PyramidFactory() {
    }

    public static Pyramid createPyramid(List<List<Integer>> numbers) {
        List<List<Brick>> bricks = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            List<Integer> numbersInLine = numbers.get(i);
            List<Brick> bricksInLine = new ArrayList<>();

            for (int j = 0; j < numbersInLine.size(); j++) {
                Integer number = numbersInLine.get(j);
                Index index = Index.create(i, j);
                Brick brick = Brick.create(index, number);
                bricksInLine.add(brick);
            }

            bricks.add(bricksInLine);
        }

        return new Pyramid(bricks);
    }
}
