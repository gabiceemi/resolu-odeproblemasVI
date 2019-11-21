/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

public class Solicitacao {
    
    private String data;
    private int status;
    private int produto;
    private String descricao;
    private String descricaoC;
    private String situacao;
    private int almoxarifeSolicitante;
    private int almoxarifadoDestino;
    private int quantidade;
    private int quantidadeDisponivel;
    private String campus;
    private int id;
    
    public Solicitacao() {
        
    }
    
    public Solicitacao(String descricaoC, int id, String campus, String data, String situacao, int status, String descricao, int produto, int almoxarifeSolicitante, int almoxarifadoDestino, int quantidade) {
        this.data = data;
        this.status = status;
        this.descricao = descricao;
        this.produto = produto;
        this.descricaoC = descricaoC;
        this.situacao = situacao;
        this.almoxarifeSolicitante = almoxarifeSolicitante;
        this.almoxarifadoDestino = almoxarifadoDestino;
        this.quantidade = quantidade;
        this.campus = campus;
        this.id = id;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the produto
     */
    public int getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(int produto) {
        this.produto = produto;
    }

    /**
     * @return the almoxarifadoSolicitante
     */
    public int getAlmoxareSolicitante() {
        return getAlmoxarifeSolicitante();
    }

    /**
     * @param almoxarifadoSolicitante the almoxarifadoSolicitante to set
     */
    public void setAlmoxarifeSolicitante(int almoxarifeSolicitante) {
        this.almoxarifeSolicitante = almoxarifeSolicitante;
    }

    /**
     * @return the almoxarifadoDestino
     */
    public int getAlmoxarifadoDestino() {
        return almoxarifadoDestino;
    }

    /**
     * @param almoxarifadoDestino the almoxarifadoDestino to set
     */
    public void setAlmoxarifadoDestino(int almoxarifadoDestino) {
        this.almoxarifadoDestino = almoxarifadoDestino;
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the almoxarifeSolicitante
     */
    public int getAlmoxarifeSolicitante() {
        return almoxarifeSolicitante;
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
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
    
}
