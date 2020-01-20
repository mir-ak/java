import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;
 
public class DeviseConvert extends Application {
    private HBox root;
    private Button hello = new Button ("Hello");
    private Label l = new Label ("World");
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Test HBox");
        root = new HBox(); //specing par defaut vaut 0. Si on passe un double en argument on fixe l'espacement entre les composants.
        root.setAlignment (Pos.CENTER);
        root.getChildren().add(hello);       
        root.getChildren().add(l);       
 
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
       
    }
}
