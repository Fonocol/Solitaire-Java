import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    private Stage stage;
    private VBox view;

    public MainMenu(Stage stage) {
        this.stage = stage;
        createMenu();
    }

    private void createMenu() {
        view = new VBox(20);
        view.setAlignment(Pos.CENTER);

        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
            System.out.println("Start");
            GameScene gameScene = new GameScene(stage);
            stage.setScene(new Scene(gameScene.getView(), 800, 600));
        });

        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> {
            System.exit(0);
        });

        Button aboutButton = new Button("About");
        aboutButton.setOnAction(e -> {
            // Afficher des informations sur le jeu
        });

        view.getChildren().addAll(startButton, quitButton, aboutButton);
    }

    public VBox getView() {
        return view;
    }
}
