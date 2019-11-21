/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ItemDAO;
import DAO.RequisicaoMensalDAO;
import Model.Almoxarifado;
import Model.Produto;
import Model.RequisicaoMensal;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "requisicaoMensalBean")
public class RequisicaoMensalBean {

    private Almoxarifado almoxarifado;
    private Produto produto;
    private int qtdDisp;
    private int qtdSolicitada;
    private RequisicaoMensalDAO rmDAO = new RequisicaoMensalDAO();
    ArrayList<RequisicaoMensal> rm = new ArrayList<>();
    private String busca;
    private int id;

  

    public void pesquisar() {
        rm = rmDAO.buscarTodos();
    }

    public void atenderRequisicaoMensal(RequisicaoMensal requisicao) {
       RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        if (rmDAO.updateStatus(requisicao.getId()) == true) {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Aprovada", "Requisição aprovada com sucesso!");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Não foi possível aprovar a requisição!");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    public void negarRequisicaoMensal(RequisicaoMensal rm){
        
    }
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtdDisp() {
        return qtdDisp;
    }

    public void setQtdDisp(int qtdDisp) {
        this.qtdDisp = qtdDisp;
    }

    public int getQtdSolicitada() {
        return qtdSolicitada;
    }

    public void setQtdSolicitada(int qtdSolicitada) {
        this.qtdSolicitada = qtdSolicitada;
    }

    public RequisicaoMensalDAO getRmDAO() {
        return rmDAO;
    }

    public void setRmDAO(RequisicaoMensalDAO rmDAO) {
        this.rmDAO = rmDAO;
    }

    public ArrayList<RequisicaoMensal> getRm() {
        return rm;
    }

    public void setRm(ArrayList<RequisicaoMensal> rm) {
        this.rm = rm;
    }

    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }
}
