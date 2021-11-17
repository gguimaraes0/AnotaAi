package Controllers;

import DAO.ClienteDAO;
import Main.Main;
import common.VO.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuInicial {

    private Stage loginStage;
    @FXML
    private Button txt_Email;
    @FXML
    private Label lbl_UsuarioNome;
    @FXML
    private AnchorPane apEscolhaLogin;
   //private Label lbl_UsuarioNome = this;
   public Cliente cliente;

    public void FecharTelas() {
        Stage stageMenu = (Stage) apEscolhaLogin.getScene().getWindow();
        Stage stageTelaLogin = (Stage) apEscolhaLogin.getScene().getWindow();

        stageTelaLogin.close();
        stageMenu.close();
    }
    public void initialize(Cliente cliente){
        this.cliente = cliente;
        this.lbl_UsuarioNome.setText(cliente.getnome());
    }

    void setLoginStage(Stage loginWindow) {
        loginStage = loginWindow;
    }
}