package org.example.pyramid;

import org.example.pyramid.brick.Brick;
import org.example.pyramid.path.Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pyramid {

    private final List<List<Brick>> bricks;

    private final List<Path> paths = new ArrayList<>();

    Pyramid(List<List<Brick>> bricks) {
        this.bricks = bricks;
        setFirstPath();
    }

    private void setFirstPath() {
        // First Brick is First Path
        Brick firstBrick = bricks.get(0).get(0);
        Path firstPath = Path.create(new ArrayList<>(Arrays.asList(firstBrick)));
        paths.add(firstPath);
    }

    public List<List<Brick>> getBricks() {
        return bricks;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public void addPaths(List<Path> newPaths) {
        paths.addAll(newPaths);
    }
}
