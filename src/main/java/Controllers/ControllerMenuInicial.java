package Controllers;

import DAO.ClienteDAO;
import DAO.DespesaDAO;
import Main.Main;
import common.VO.Cliente;
import common.VO.Despesa;
import common.VO.InstituicaoPagamento;
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
    private ChoiceBox ch_TipoMovimentoGasto, ch_TipoInstituicao;
    @FXML //campos despesa
    private TextField txt_NomeRegistrarGasto, txt_ValorMovimentoGasto, txt_DescricaoMovimentoGasto, txt_ParcelasMovimentoGasto, txt_DataMovimentoGasto;
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
        String valorDespesa = txt_ValorMovimentoGasto.getText();
        String descDespesa = txt_DescricaoMovimentoGasto.getText();
        String tipoDespesa = ch_TipoMovimentoGasto.getValue().toString();
        String instituicaoSelec = ch_TipoInstituicao.getValue().toString();
        String parcelasDespesa = txt_ParcelasMovimentoGasto.getText();
        String dataDespesa = txt_DataMovimentoGasto.getText();

        Despesa novaDespesa = new Despesa();
        novaDespesa.setCliente_id(cliente);
        novaDespesa.setDescricao(nomeGasto + " | " + descDespesa);
        novaDespesa.setDatavencimento(dataDespesa);
        novaDespesa.setValor(valorDespesa);
        novaDespesa.setTipo(pegaTipo(tipoDespesa));
        novaDespesa.setInstituicaoPagamento(pegaInst(instituicaoSelec));

        DespesaDAO daoDespesa = new DespesaDAO();
        Boolean cadastro = daoDespesa.insert(novaDespesa);
    }

    private InstituicaoPagamento pegaInst(String instSelecNome){
        Integer idInst = 6;
        switch(instSelecNome){
            case"Itaú":
                idInst = 1;
                break;
            case"Banco do Brasil":
                idInst = 2;
                break;
            case"Caixa Econômica":
                idInst = 3;
                break;
            case"Santander":
                idInst = 4;
                break;
            case"Nubank":
                idInst = 5;
                break;
            case"Inter":
                idInst = 6;
                break;
            case"Bradesco":
                idInst = 7;
                break;
            case"Banco Safra":
                idInst = 8;
                break;
            case"Banco PAN":
                idInst = 9;
                break;
        }
        InstituicaoPagamento instiSelec = new InstituicaoPagamento();
        instiSelec.setNome(instSelecNome);
        instiSelec.setIdInstituicaoPagamento(idInst);

        return instiSelec;
    }

    private Tipo pegaTipo(String tipoDespesa){
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
        Tipo tipoSelec = new Tipo();
        tipoSelec.setNome(tipoDespesa);
        tipoSelec.setIdTipo(idTipo);

        return tipoSelec;
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
