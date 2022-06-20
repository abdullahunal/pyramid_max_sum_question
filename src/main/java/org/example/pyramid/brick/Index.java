package org.example.pyramid.brick;

import java.util.Objects;

public class Index {

    private final int i;

    private final int j;

    private Index(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public static Index create(int i, int j) {
        return new Index(i, j);
    }

    public boolean equals(Index index) {
        return index.i == i && index.j == j;
    }

    public boolean equalsVertically(Index index) {
        return index.i == i;
    }

    public boolean equalsHorizontally(Index index) {
        return index.j == j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return i == index.i && j == index.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }
}
