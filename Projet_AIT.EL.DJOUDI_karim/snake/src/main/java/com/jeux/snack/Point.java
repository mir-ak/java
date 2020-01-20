package com.jeux.snack;

import javafx.scene.paint.Color;
// class pour les point a manger par le serpent
public class Point {
    private final int x;
    private final int y;
    public final Color COLOR;

    Point(final int x, final int y, Color COLOR) {
        this.x = x;
        this.y = y;
        this.COLOR = COLOR;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point translate(int dx, int dy) {
        return new Point(x + dx, y + dy,this.COLOR);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Point)) return false;
        Point point = (Point) other;
        return x == point.x & y == point.y;
    }

    public String toString() {
        return x + ", " + y;
    }
}
