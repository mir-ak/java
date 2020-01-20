package com.jeux.snack;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {
    // taille de la fentre
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private GameLoop loop;
    private Grid grid;
    private GraphicsContext context;
    //en peut faire mieu que ça !!!!!!!!
    private GameMenu gamemenu;
    private Canvas canvas;
    private Pane  rootMenu;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        rootMenu= new Pane();
        rootMenu.setPrefSize(800,600);
        gamemenu = new GameMenu();
        gamemenu.setVisible(true);
        gamemenu.setOpacity(0.6);
        rootMenu.getChildren().add(gamemenu);

        StackPane root = new StackPane();
        canvas = new Canvas(WIDTH, HEIGHT);
        context = canvas.getGraphicsContext2D();
        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(this::handle);

        reset();
        canvas.setVisible(false);
        root.getChildren().addAll(canvas,rootMenu);
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("Snake");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setScene(scene);
        primaryStage.show();

        (new Thread(loop)).start();
    }

    private void reset() {
        grid = new Grid(WIDTH, HEIGHT);
        loop = new GameLoop(grid, context);
        Painter.paint(grid, context);
    }

    private void handle(KeyEvent e) {
        Snake snake = grid.getSnake();
        if (loop.isKeyPressed()) {
            return;
        }
        switch (e.getCode()) {
            case UP:
                snake.setUp();
                break;
            case DOWN:
                snake.setDown();
                break;
            case LEFT:
                snake.setLeft();
                break;
            case RIGHT:
                snake.setRight();
                break;
            case ENTER:
                if (loop.isPaused()) {
                    reset();
                    (new Thread(loop)).start();
                }
            case ESCAPE:
                if (loop.isPaused()) {
                    System.exit(0);
                }
        }
    }

    //class pour cree le menu du jeu
  public class GameMenu extends Parent{
  	GameMenu(){
  		Pane root = new Pane();
  		Rectangle rt1 = new Rectangle(800,600);
        Rectangle rt2 = new Rectangle(0,440,800,350);
  		VBox menu = new VBox(50);
  		// faire une image =====================
        Image mon_image = new Image("file:SnakeItUpLogoTiles-Background.png",800,800,true,true);
        ImageView mon_imageview = new ImageView(mon_image);
        rootMenu.getChildren().add(mon_imageview);
  		Button start = new Button("START");
  		Button exit = new Button("Exit");
        //Text text = new Text("Bienvenue ");
        //text.setFont(Font.font ( "Amble CN" , FontWeight.BOLD, 50));
        //text.setFill(Color.GREEN);
        rt1.setOpacity(0.4);
  		rt1.setFill(Color.ALICEBLUE);
  		rt2.setOpacity(0.8);
  		rt2.setFill(Color.GREENYELLOW);

  		start.setOnMouseClicked(event -> {
        canvas.setVisible(true);
        rootMenu.setVisible(false);
        
  		});
  		exit.setOnMouseClicked(event -> {
  			System.exit(0);
  		});

  		menu.setTranslateX(350);
        menu.setTranslateY(100);
  		//menu.getChildren().add(text);
  		menu.getChildren().add(start);
  		menu.getChildren().add(exit);
      // pour afficher Mon nom ====================
      Group sign = new Group();
      sign.setTranslateX(50);
      sign.setTranslateY(500);
      Text textCreator = new Text(200, 20, "AIT EL DJOUDI Karim");
      textCreator.setFont(new Font(30));
      textCreator.setFill(Color.BLACK);
      sign.getChildren().add(textCreator);
      //=============================================

  		root.getChildren().addAll(rt1,rt2,menu,sign);
  		this.getChildren().add(root);

  	}
  }
  // class pour cree des bouton pour le menu
  public static class Button extends StackPane{
  	Button(String name){
  		Text text = new Text(name);
  		text.setFont(Font.font(30));
  		text.setFill(Color.WHITE);

  		Circle rt = new Circle(50);
  		rt.setOpacity(50);
  		rt.setFill(Color.RED);
  		setAlignment(Pos.CENTER);
  		this.getChildren().addAll(rt,text);
  	}
  }
}
