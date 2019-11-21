/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.AlmoxarifadoDAO;
import DAO.AlmoxarifeDAO;
import DAO.ItemDAO;
import DAO.SolicitacaoDAO;
import Model.Item;
import Model.Produto;
import Model.Solicitacao;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "solicitacaoBean")
public class SolicitacaoBean implements Serializable {

    private Solicitacao solicitacao = new Solicitacao();
    private ArrayList<Solicitacao> solicitacoes = new ArrayList<>();
    private Produto produto;
    private String almoxarife;
    private Item i;
    private int codigo;
    private int quantidade;
    private int quantidadeDisponivel;
    private String descricao;
    private String descricaoC;
    private String campus;
    private String status;
    private int solicitacaoSelecionada;
    ItemDAO item = new ItemDAO();
    SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
    AlmoxarifadoDAO almoxarifadoDAO = new AlmoxarifadoDAO();
    AlmoxarifeDAO almoxarifeDAO = new AlmoxarifeDAO();

    public void adicionar(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        if (item.select(codigo, campus, quantidade) != null) {
            loggedIn = true;
            solicitacao = item.select(codigo, campus, quantidade);
            solicitacao.setData(getDataAtual());
            solicitacaoDAO.insert(getQuantidade(), solicitacao.getData(), solicitacao.getProduto(), almoxarifadoDAO.selectID(campus), almoxarifeDAO.selectID(AutenticacaoBean.siape));
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Enviado", "Solicitação enviada com sucesso!");
        } else {
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro", "Não foi possível enviar a solicitação!");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }

    public void visualizarSolicitacoes() {
        solicitacoes = solicitacaoDAO.selectAll(almoxarifadoDAO.selectAlmoxarifadoPorSiape(AutenticacaoBean.siape));

    }
    
    public void visualizarStatusSolicitacoes() {
        solicitacoes = solicitacaoDAO.selectSolicitacoes(almoxarifeDAO.selectID(AutenticacaoBean.siape));

    }

    public void aprovarSolicitacao(Solicitacao solicitacao) {
        if (solicitacaoDAO.updateStatus(solicitacao.getId()) == true) {
            item.updateQuantidade(solicitacao.getQuantidade(), solicitacao.getAlmoxarifadoDestino(), solicitacao.getProduto());
        } else {
        }
    }
    
    public void recebidaSolicitacao(Solicitacao solicitacao) {
        if (solicitacaoDAO.updateStatusRecebido(solicitacao.getId()) == true) {
            item.updateQuantidadeRecebida(solicitacao.getQuantidade(), almoxarifeDAO.selectAlmoxarifado(solicitacao.getAlmoxarifeSolicitante()), solicitacao.getProduto());
        } else {
        }
    }

    public void negarSolicitacao(Solicitacao solicitacao) {
        /*
        if (solicitacaoDAO.updateStatusNegado(solicitacao.getId()) == true) {
        } else {
        }*/
    }
    
    public String getDataAtual() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * @return the solicitacao
     */
    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    /**
     * @param solicitacao the solicitacao to set
     */
    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the campus
     */
    public String getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(String campus) {
        this.campus = campus;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the descricaoC
     */
    public String getDescricaoC() {
        return descricaoC;
    }

    /**
     * @param descricaoC the descricaoC to set
     */
    public void setDescricaoC(String descricaoC) {
        this.descricaoC = descricaoC;
    }

    /**
     * @return the solicitacoes
     */
    public ArrayList<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    /**
     * @param solicitacoes the solicitacoes to set
     */
    public void setSolicitacoes(ArrayList<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    /**
     * @return the quantidadeDisponivel
     */
    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    /**
     * @param quantidadeDisponivel the quantidadeDisponivel to set
     */
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * @return the solicitacaoSelecionada
     */
    public int getSolicitacaoSelecionada() {
        return solicitacaoSelecionada;
    }

    /**
     * @param solicitacaoSelecionada the solicitacaoSelecionada to set
     */
    public void setSolicitacaoSelecionada(int solicitacaoSelecionada) {
        this.solicitacaoSelecionada = solicitacaoSelecionada;
    }

}
