package com.ruskaof.client.data;

import java.util.Objects;

public class Location {
    public Location(float x, long y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    private float x;
    private long y;
    private String name; //not empty not null

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Float.compare(location.x, x) == 0 && y == location.y && Objects.equals(name, location.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, name);
    }
}
