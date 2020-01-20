package com.jeux.snack;

import javafx.scene.paint.Color;

import java.util.Random;
public class Grid {
    public static final int SIZE = 10;
    public static final Color COLOR = new Color(0.1, 0.1, 0.1, 1);

    private final int cols;
    private final int rows;

    private Snake snake;
    private Point point;

    public Grid(final double width, final double height) {
        rows = (int) width / SIZE;
        cols = (int) height / SIZE;
        snake = new Snake(this, new Point(rows / 2, cols / 2,Color.ORANGE));
        point = getRandomPoint();
    }

    public boolean safeOfWall(Point point) {
        int x = point.getX();
        int y = point.getY();
        if (x >= rows) return false;
        if (y >= cols) return false;
        if (x < 0) return false;
        if (y < 0) return false;
        return true;
    }
    // cette méthode génere le point suivant sa couleur et sa position dans la grid
    private Point getRandomPoint() {
        Random random = new Random();
        Point point;
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);
        do {
            point = new Point(random.nextInt(rows), random.nextInt(cols),(Color)Color.rgb(r,g,b));
        } while (point.equals(snake.getHead()));
        return point;
    }
    // méthode qui gére la mise a jour du jeu; géner des point, bouger et étendre le serpent
    public void update() {
        if (point.equals(snake.getHead())) {
            snake.extend();
            point = getRandomPoint();
        } else {
            snake.move();
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public double getWidth() {
        return rows * SIZE;
    }

    public double getHeight() {
        return cols * SIZE;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getPoint() {
        return point;
    }

    public int getSize(){
	     return SIZE;
    }
}
