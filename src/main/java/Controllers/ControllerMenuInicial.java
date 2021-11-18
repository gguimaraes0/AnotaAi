package Controllers;

import DAO.ClienteDAO;
import DAO.DespesaDAO;
import DAO.ReceitaDAO;
import Main.Main;
import common.VO.*;
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
import java.util.List;

public class ControllerMenuInicial {

    private Stage loginStage;
    @FXML
    private Label lbl_UsuarioNome, lbl_textList;
    //campos despesa
    @FXML
    private ChoiceBox ch_TipoMovimentoGasto, ch_TipoInstituicao;
    @FXML
    private TextField txt_NomeRegistrarGasto, txt_ValorMovimentoGasto, txt_DescricaoMovimentoGasto, txt_ParcelasMovimentoGasto, txt_DataMovimentoGasto;

    //campos receita
    @FXML
    private TextField txt_NomeRegistrarGanho, txt_ValorMovimentoGanho, txt_DescricaoMovimentoGanho, txt_DataMovimentoGanho;
    @FXML
    private ChoiceBox ch_TipoMovimentoGanho, ch_TipoInstituicaoGanho;
    @FXML
    private AnchorPane apEscolhaLogin, apRegistrarMovimentacao;
    //private Label lbl_UsuarioNome = this;
    public Cliente cliente;

    public void btn_ListarReceita_click(MouseEvent mouseEvent) throws IOException {
        listarReceita();
    }

    public void btn_ListarDespesa_click(MouseEvent mouseEvent) throws IOException {
        listarDespesa();
    }

    public void listarDespesa() throws IOException {
        DespesaDAO daoDespesa = new DespesaDAO();
        List<Despesa> despesas = daoDespesa.selectAllbyCliente(cliente);

        String texto = "";

        for (int i = 0; i < despesas.size(); i++) {
            texto += "Despesa " + (i + 1) +
                    "\nDescrição: " + despesas.get(i).getDescricao() +
                    "\nValor: " + despesas.get(i).getValor() +
                    "\nData de Vencimento: " + despesas.get(i).getDatavencimento() +
                    "\nInstituição de Pagamento: " + despesas.get(i).getInstituicaoPagamento().getNome() +
                    "\nTipo de Despesa: " + despesas.get(i).getTipo().getNome() +
                    "\n\n";
        }

        lbl_textList.setText(texto);
    }

    public void listarReceita() throws IOException {
        ReceitaDAO daoReceita = new ReceitaDAO();
        List<Receita> receitas = daoReceita.selectAllbyCliente(cliente);

        String texto = "";

        for (int i = 0; i < receitas.size(); i++) {
            texto += "Receita " + (i + 1) +
                    "\nDescrição: " + receitas.get(i).getDescricao() +
                    "\nValor: " + receitas.get(i).getValor() +
                    "\nData de recebimento: " + receitas.get(i).getData_recebimento() +
                    "\nInstituição de Pagamento: " + receitas.get(i).getInstituicaoPagamento().getNome() +
                    "\nTipo de Despesa: " + receitas.get(i).getTipo().getNome() +
                    "\n\n";
        }

        lbl_textList.setText(texto);
    }

    public void btn_SalvarReceita_click(MouseEvent mouseEvent) throws IOException {
        addReceita();
    }

    public void addReceita() throws IOException {
        String nomeGanho = txt_NomeRegistrarGanho.getText();
        String valorGanho = txt_ValorMovimentoGanho.getText();
        String descGanho = txt_DescricaoMovimentoGanho.getText();
        String tipoGanho = ch_TipoMovimentoGanho.getValue().toString();
        String instituicaoSelecGanho = ch_TipoInstituicaoGanho.getValue().toString();
        String dataGanho = txt_DataMovimentoGanho.getText();

        Receita novaReceita = new Receita();
        novaReceita.setCliente(cliente);
        novaReceita.setDescricao(nomeGanho + " | " + descGanho);
        novaReceita.setData_recebimento(dataGanho);
        novaReceita.setValor(valorGanho);
        novaReceita.setTipo(pegaTipo(tipoGanho));
        novaReceita.setInstituicaoPagamento(pegaInst(instituicaoSelecGanho));

        ReceitaDAO daoReceita = new ReceitaDAO();
        Boolean cadastro = daoReceita.insert(novaReceita);
    }

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
        novaDespesa.setCliente(cliente);
        novaDespesa.setDescricao(nomeGasto + " | " + descDespesa);
        novaDespesa.setDatavencimento(dataDespesa);
        novaDespesa.setValor(valorDespesa);
        novaDespesa.setTipo(pegaTipo(tipoDespesa));
        novaDespesa.setInstituicaoPagamento(pegaInst(instituicaoSelec));

        DespesaDAO daoDespesa = new DespesaDAO();
        Boolean cadastro = daoDespesa.insert(novaDespesa);
    }

    private InstituicaoPagamento pegaInst(String instSelecNome) {
        Integer idInst = 6;
        switch (instSelecNome) {
            case "Itaú":
                idInst = 1;
                break;
            case "Banco do Brasil":
                idInst = 2;
                break;
            case "Caixa Econômica":
                idInst = 3;
                break;
            case "Santander":
                idInst = 4;
                break;
            case "Nubank":
                idInst = 5;
                break;
            case "Inter":
                idInst = 6;
                break;
            case "Bradesco":
                idInst = 7;
                break;
            case "Banco Safra":
                idInst = 8;
                break;
            case "Banco PAN":
                idInst = 9;
                break;
        }
        InstituicaoPagamento instiSelec = new InstituicaoPagamento();
        instiSelec.setNome(instSelecNome);
        instiSelec.setIdInstituicaoPagamento(idInst);

        return instiSelec;
    }

    private Tipo pegaTipo(String tipoDespesa) {
        Integer idTipo = 6;
        switch (tipoDespesa) {
            case "Luz":
                idTipo = 1;
                break;
            case "Telefone":
                idTipo = 2;
                break;
            case "Internet":
                idTipo = 3;
                break;
            case "Salário":
                idTipo = 4;
                break;
            case "Investimentos":
                idTipo = 5;
                break;
            case "Outros":
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

    public void btn_ListarDespesaReceita_click(MouseEvent mouseEvent) throws IOException {
        abreTelaListagem();
    }

    public void abreTelaListagem() throws IOException {
        Stage ControllerMenuInicial = new Stage();
        ControllerMenuInicial.initModality(Modality.WINDOW_MODAL);
        Parent root;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControllerMenuInicial.class.getResource("/Telas/TelaListarDespRec.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        ControllerMenuInicial.setScene(scene);
        // Define a pessoa no controller.
        ControllerMenuInicial controller = loader.getController();
        controller.setLoginStage(ControllerMenuInicial);
        controller.initialize(cliente);
        ControllerMenuInicial.showAndWait();
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
