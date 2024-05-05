import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class MainSceneConttroller {

    @FXML
    private Canvas canvas;

    private GraphicsContext gc;

    @FXML
    public void initialize() {
        // Obtenez le contexte graphique du canevas
        gc = canvas.getGraphicsContext2D();

        // Dessinez ce que vous voulez sur le canevas ici
        gc.strokeText("Hello, world!", 50, 50);
    }
}

/*public class MainSceneConttroller {

    @FXML
    private TextField tfTitle;

    @FXML
    void btnOkCliked(ActionEvent event) {
        Stage mainWindow = (Stage) tfTitle.getScene().getWindow();
        String title = tfTitle.getText();
        mainWindow.setTitle(title);

    }

}*/
