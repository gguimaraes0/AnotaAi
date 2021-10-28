package Controllers;

import com.example.anota6.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTelaCadastro extends HelloApplication {
    @FXML
    private TextField txt_Nome, txt_Email, txt_Senha;

    public void btn_VoltaMenu_Click(InputEvent e) throws IOException {
        fecharTela(e);
    }

    public void btn_FazerCadastro_Click(InputEvent e) throws IOException {
        fazerCadastro(e);
    }

    public void fecharTela(InputEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void fazerCadastro(InputEvent e) {
        String nome = txt_Nome.getText();
        String email = txt_Email.getText();
        String senha = txt_Senha.getText();

        if (nome.isEmpty())
            campoEmBrancoCadastro("nome");

        else if (email.isEmpty() || !email.matches("\\S+@\\S+\\.\\S+"))
            campoEmBrancoCadastro("email");

        else if (senha.isEmpty())
            campoEmBrancoCadastro("senha");

        //else
        //fazer o cadastro
    }

    public void campoEmBrancoCadastro(String campo) {
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.WARNING);
        a.setContentText("Não esqueça de preencher corretamente o campo " + campo);
        a.showAndWait();
    }
}
