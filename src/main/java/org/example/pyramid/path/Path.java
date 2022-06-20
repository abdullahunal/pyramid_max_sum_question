package org.example.pyramid.path;

import org.example.pyramid.brick.Brick;
import org.example.pyramid.brick.Index;

import java.util.ArrayList;
import java.util.List;

public class Path {

    private final List<Brick> bricks;

    private Path(List<Brick> bricks) {
        this.bricks = bricks;
    }

    public static Path create(List<Brick> bricks) {
        return new Path(bricks);
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (Brick brick : bricks)
            numbers.add(brick.getNumber());
        return numbers;
    }

    public int getSum() {
        int sum = 0;
        for (Integer number : getNumbers())
            sum += number;
        return sum;
    }

    public boolean hasIndex(Index index) {
        for (Brick brick : bricks) {
            if (brick.getIndex().equals(index))
                return true;
        }
        return false;
    }

    public boolean hasNumber(Integer number) {
        for (Brick brick : bricks) {
            if (brick.getNumber() == number)
                return true;
        }
        return false;
    }

    public void addBrick(Brick brick) {
        bricks.add(brick);
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public Path fork(Brick brick) {
        Path newPath = new Path(new ArrayList<>(bricks));
        newPath.addBrick(brick);
        return newPath;
    }

    public int getLength() {
        return bricks.size();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
