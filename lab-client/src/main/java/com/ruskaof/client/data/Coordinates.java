package com.ruskaof.client.data;

import java.util.Objects;

public class Coordinates {

    private final long x; //> -896
    private final Double y; //<=135, not null

    public Coordinates(long x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{"
                + "x=" + x
                + ", y=" + y
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coordinates that = (Coordinates) o;
        return x == that.x && Objects.equals(y, that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
