package Controllers;

import DAO.ClienteDAO;
import Main.Main;
import common.VO.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTelaLogin {
    @FXML
    private TextField txt_Email, txt_Senha;
    @FXML
    private AnchorPane apEscolhaLogin, apEfetuarLogin;


    @FXML
    public void FecharTelas() {
        Stage stageMenu = (Stage) apEscolhaLogin.getScene().getWindow();
        Stage stageTelaLogin = (Stage) apEscolhaLogin.getScene().getWindow();

        stageTelaLogin.close();
        stageMenu.close();
    }

    public void btnLogin_Click(MouseEvent mouseEvent) throws IOException {
        checaUser();
    }

    public void checaUser() throws IOException {
        String email = txt_Email.getText();
        String senha = txt_Senha.getText();

        ClienteDAO clidao = new ClienteDAO();
        Cliente user =  clidao.selectByEmail(email);

        if(user == null || !user.getPassword().equals(senha))
        {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Usuário ou senha incorreta!");
            a.showAndWait();
        }
        else{
            Stage ControllerMenuInicial = new Stage();
            ControllerMenuInicial.initModality(Modality.WINDOW_MODAL);
            Parent root;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ControllerMenuInicial.class.getResource("/Telas/TelaMenuInicial.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            ControllerMenuInicial.setScene(scene);
            // Define a pessoa no controller.
            ControllerMenuInicial controller = loader.getController();
            controller.setLoginStage(ControllerMenuInicial);
            controller.initializeUser(user);
            ControllerMenuInicial.showAndWait();

//            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/Telas/TelaMenuInicial.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            Stage stage = new Stage();
//            stage.setTitle("Anota Aí - Menu Principal");
//            //stage.initStyle(StageStyle.UTILITY);
//            stage.setScene(scene);
//            stage.show();
//            FecharTelas();
        }


    }
}
