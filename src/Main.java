import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 800, 600);
            MainMenu mainMenu = new MainMenu(primaryStage);
            root.setCenter(mainMenu.getView());

            primaryStage.setTitle("Simple Game Interface");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}



/*public class Main {
    public static void main(String [] args){
        Carte c1 = new Carte(10,2);
        Carte c2 = new Carte(Carte.ROI,Carte.TREFLES);
        System.out.println(c1);
        System.out.println(c2.getColor());
        System.out.println(c2);
    }
}*/