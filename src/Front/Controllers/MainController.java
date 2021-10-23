package Front.Controllers;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    public AnchorPane apViewer;
    public JFXButton btn_Login;
    public JFXButton btn_CanastaLogin;

    @FXML
    protected void initialize() throws IOException {
        resetColor();
        btn_Login.setOpacity(1);
        btn_CanastaLogin.setOpacity(1);
    }
    private void resetColor(){
        btn_Login.setOpacity(0.5);
        btn_CanastaLogin.setOpacity(0.5);
    }

    public void btn_Login_Click(MouseEvent mouseEvent) {
    }

    public void btn_CanastaLogin_Click(MouseEvent mouseEvent) {
    }
}
