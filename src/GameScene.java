import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameScene {
    private Stage stage;
    private VBox view;

    public GameScene(Stage stage) {
        this.stage = stage;
        createGameScene();
    }

    private void createGameScene() {
        view = new VBox(20);
        view.setAlignment(Pos.CENTER);

        Button menuButton = new Button("Menu");
        menuButton.setOnAction(e -> {
            MainMenu mainMenu = new MainMenu(stage);
            stage.setScene(new Scene(mainMenu.getView(), 800, 600));
        });

        // Ajouter d'autres éléments de jeu ici

        view.getChildren().add(menuButton);
    }

    public VBox getView() {
        return view;
    }
}
