package Controllers;

import DAO.ClienteDAO;
import DAO.DespesaDAO;
import Main.Main;
import common.VO.Cliente;
import common.VO.Despesa;
import common.VO.Tipo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenuInicial {

    private Stage loginStage;
    @FXML
    private Label lbl_UsuarioNome;
    @FXML
    private ChoiceBox ch_TipoMovimentoGasto;
    @FXML //campos despesa
    private TextField txt_NomeRegistrarGasto, txt_ValorMovimentoGasto, txt_DescricaoMovimentoGasto, txt_TipoMovimentoGasto, txt_ParcelasMovimentoGasto, txt_DataMovimentoGasto;
    //@FXML //campos receita
    //private TextField ;
    @FXML
    private AnchorPane apEscolhaLogin, apRegistrarMovimentacao;
    //private Label lbl_UsuarioNome = this;
    public Cliente cliente;

    public void btn_AdicionaDespesa_click(MouseEvent mouseEvent) throws IOException {
        addDespesa();
    }

    public void addDespesa() throws IOException {
        String nomeGasto = txt_NomeRegistrarGasto.getText();
        String valorDespesa = txt_NomeRegistrarGasto.getText();
        String descDespesa = txt_NomeRegistrarGasto.getText();
        String tipoDespesa = ch_TipoMovimentoGasto.getValue().toString();
        String parcelasDespesa = txt_NomeRegistrarGasto.getText();
        String dataDespesa = txt_NomeRegistrarGasto.getText();

        Integer idTipo = 6;
        switch(tipoDespesa){
            case"Luz":
                idTipo = 1;
                break;
            case"Telefone":
                idTipo = 2;
                break;
            case"Internet":
                idTipo = 3;
                break;
            case"Salário":
                idTipo = 4;
                break;
            case"Investimentos":
                idTipo = 5;
                break;
            case"Outros":
                idTipo = 6;
                break;
        }

        Despesa novaDespesa = new Despesa();
        novaDespesa.setCliente(cliente.getId());
        novaDespesa.setDescricao(descDespesa);
        novaDespesa.setDatavencimento(dataDespesa);
        novaDespesa.setValor(valorDespesa);
        novaDespesa.setTipo(idTipo);
        novaDespesa.setInstituicaoPagamento(2);

        DespesaDAO daoDespesa = new DespesaDAO();
        Boolean cadastro = daoDespesa.insert(novaDespesa);

    }

    public void btn_RegistrarMovimentacaoMenu_click(MouseEvent mouseEvent) throws IOException {
        abreTelaRM();
    }

    public void abreTelaRM() throws IOException {
        Stage ControllerMenuInicial = new Stage();
        ControllerMenuInicial.initModality(Modality.WINDOW_MODAL);
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControllerMenuInicial.class.getResource("/Telas/TelaRegistrarMovimentacao.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        ControllerMenuInicial.setScene(scene);
        // Define a pessoa no controller.
        ControllerMenuInicial controller = loader.getController();
        controller.setLoginStage(ControllerMenuInicial);
        controller.initialize(cliente);
        ControllerMenuInicial.showAndWait();
    }

    public void btn_VoltarTelaRM_click(MouseEvent mouseEvent) throws IOException {
        fecharTelaRM();
    }

    public void fecharTelaRM() throws IOException {
        Stage stage = (Stage) apEscolhaLogin.getScene().getWindow();
        stage.close();
    }


    public void FecharTelas() {
        Stage stageMenu = (Stage) apEscolhaLogin.getScene().getWindow();
        Stage stageTelaLogin = (Stage) apEscolhaLogin.getScene().getWindow();

        stageTelaLogin.close();
        stageMenu.close();
    }

    public void initialize(Cliente cliente) {
        this.cliente = cliente;
        //this.lbl_UsuarioNome.setText(cliente.getnome());
    }

    void setLoginStage(Stage loginWindow) {
        loginStage = loginWindow;
    }
}
