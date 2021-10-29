package Controllers;

import DAO.ClienteDAO;
import common.VO.Cliente;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTelaCadastro {
    @FXML
    private TextField txt_Nome, txt_Email, txt_Senha;

    public void btn_VoltaMenu_Click(InputEvent e) {
        fecharTela(e);
    }

    public void btn_FazerCadastro_Click(InputEvent e) {
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

        if (email.isEmpty() || !email.matches("\\S+@\\S+\\.\\S+"))
            campoEmBrancoCadastro("email");

        else if (nome.isEmpty())
            campoEmBrancoCadastro("nome");

        else if (senha.isEmpty())
            campoEmBrancoCadastro("senha");

        else {
            Cliente novoUser = new Cliente();
            novoUser.setEmail(email);
            novoUser.setnome(nome);
            novoUser.setPassword(senha);

            inserirCliente(novoUser, e);
        }
    }

    public void inserirCliente(Cliente novoUser,InputEvent e) {
        ClienteDAO daoCliente = new ClienteDAO();
        Boolean cadastro = daoCliente.insert(novoUser);
        Alert a = new Alert(Alert.AlertType.NONE);
        if (cadastro) {
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("O Cadastro foi feito com Sucesso!");
            a.showAndWait();
            fecharTela(e);
        } else {
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Houve um erro na hora do cadastro, favor tentar novamente!");
            a.showAndWait();
        }
    }

    public void campoEmBrancoCadastro(String campo) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("Não esqueça de preencher corretamente o campo " + campo);
        a.showAndWait();
    }
}
