package com.jeux.snack;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//cette class sert a dessiner les foremes et les couleurs 
public class Painter {
public static int SIZE;
    public static void paint(Grid grid, GraphicsContext gc) {
        gc.setFill(Grid.COLOR);
        gc.fillRect(0, 0, grid.getWidth(), grid.getHeight());

        //la couleur du point a manger change a chaque fois c'est plus agreable
        gc.setFill(grid.getPoint().COLOR);
        paintPoint(grid.getPoint(), gc);

        Snake snake = grid.getSnake();
        // le serpent qui change de coleur aussi selon le point a manger. on peut fixer la coleur
        //en remplace ici gc.setFill(snake.COLOR)
        gc.setFill(grid.getPoint().COLOR);
        snake.getPoints().forEach(point -> paintPoint(point, gc));
        // la tete du serpent est Orange toujours
        gc.setFill(snake.getHead().COLOR);
        paintPoint(snake.getHead(), gc);
        //à la mort du serpent sa tete devient rouge
        if (!snake.isSafe()) {
            gc.setFill(Snake.DEAD);
            paintPoint(snake.getHead(), gc);
        }
        // le score
        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + snake.getScore() + ", Niveau : "+snake.getLevel(), 10, 590);
	      SIZE = grid.getSize();
    }

    private static void paintPoint(Point point, GraphicsContext gc) {
        gc.fillOval(point.getX() * SIZE, point.getY() * SIZE, SIZE, SIZE);
    }

    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.AQUAMARINE);
        gc.fillText(" Game Over ", 350, 260);
        gc.fillText(" Appuyez sur Entrée pour rejoué ou Echape pour quitte.", 220, 300);
        //gc.fillText(" Appuyez sur Echape pour quitte.", 250, 330);
    }
}
