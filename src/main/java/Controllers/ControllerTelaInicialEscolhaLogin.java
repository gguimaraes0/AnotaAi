package Controllers;

import com.example.anota6.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerTelaInicialEscolhaLogin {
    @FXML
    private Button btn_Login, btn_CadastrarLogin;

    @FXML
    public AnchorPane apEscolhaLogin;

    @FXML
    public void EscondeTela() {
        Stage stage = (Stage) apEscolhaLogin.getScene().getWindow();
        stage.hide();
    }

    public void CriaTelaCadastro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaCadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Anota Aí - Cadastro");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }

    public void CriaTelaLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TelaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Anota Aí - Login");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();

        stage.setOpacity(00);
    }

    public void btnLogin_Click(MouseEvent mouseEvent) throws IOException {
        //EscondeTela();
        CriaTelaLogin();
    }

    public void btnCadastrarLogin_Click(MouseEvent mouseEvent) throws IOException {
        //EscondeTela();
        CriaTelaCadastro();
    }
}
