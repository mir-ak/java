package com.jeux.snack;

import javafx.scene.paint.Color;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    //la variable COLOR c'est pour que le serpant ayent une couleur unique
    public static final Color COLOR = Color.CORNSILK;
    public static final Color DEAD = Color.RED;
    public static final Color HEAD = Color.ORANGE;
    private Grid grid;
    private int length;
    private boolean safe;
    private boolean safeWall;
    private List<Point> points;
    private Point head;
    private int xVelocity;
    private int yVelocity;

    public Snake(Grid grid, Point initialPoint) {
        length = 3;
        this.grid = grid;
        points = new LinkedList<Point>();
        Point point1 = new Point(grid.getRows() / 2, grid.getCols() / 2 -1,Color.BLUE);
        Point point2 = new Point(grid.getRows() / 2, grid.getCols() / 2 -2,Color.GREEN);
        points.add(initialPoint);
        points.add(point1);
        points.add(point2);
        head = initialPoint;
        safe = true;
        safeWall = true;
        xVelocity = 0;
        yVelocity = 0;
    }

    private void growTo(Point point) {
        length++;
        checkAndAdd(point);
    }

    private void shiftTo(Point point) {
        checkAndAdd(point);
        points.remove(0);
    }

    private void checkAndAdd(Point point) {
        safeWall = grid.safeOfWall(point);
        if(points.contains(point) && length > 3){
          safe = !points.contains(point);
        }
        if(isSafe()){
          points.add(point);
          head = point;
        }
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean isSafe() {
        return  safe == true && safeWall == true;
    }

    public Point getHead() {
        return head;
    }

    private boolean isStill() {
        return xVelocity == 0 & yVelocity == 0;
    }

    public void move() {
        if (isSafe()) {
            shiftTo(head.translate(xVelocity, yVelocity));
        }
    }

    public void extend() {
        if (isSafe()) {
            growTo(head.translate(xVelocity, yVelocity));
        }
    }

    public int getScore(){
      return 100 * (this.getPoints().size() - 3) ;
    }

    public int getLevel(){
      return getScore()/1000 + 1;
    }

    public void setUp() {
        if (yVelocity == 1 && length >= 3) return;
        xVelocity = 0;
        yVelocity = -1;
    }

    public void setDown() {
        if (yVelocity == -1 && length >= 3) return;
        xVelocity = 0;
        yVelocity = 1;
    }

    public void setLeft() {
        if (xVelocity == 1 && length >= 3) return;
        xVelocity = -1;
        yVelocity = 0;
    }

    public void setRight() {
        if (xVelocity == -1 && length >= 3) return;
        xVelocity = 1;
        yVelocity = 0;
    }
}
