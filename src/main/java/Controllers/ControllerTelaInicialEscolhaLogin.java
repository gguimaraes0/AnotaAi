package Controllers;

import Main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerTelaInicialEscolhaLogin {
    @FXML
    private Button btn_Login;
    private Button btn_CadastrarLogin;
    @FXML
    private AnchorPane apEscolhaLogin;

    @FXML
    public void FecharTela()
    {
        Stage stage = (Stage) apEscolhaLogin.getScene().getWindow();
        stage.close();
        // nn funciona ainda
    }
    public void CriaTelaCadastro() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Telas/TelaCadastro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Anota Aí - Cadastro");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }
    public void CriaTelaLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Telas/TelaLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Anota Aí - Login");
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();
    }
    public void btnLogin_Click(MouseEvent mouseEvent) throws IOException {
        CriaTelaLogin();
    }
    public void btnCadastrarLogin_Click(MouseEvent mouseEvent) throws IOException {
        CriaTelaCadastro();
    }
}
