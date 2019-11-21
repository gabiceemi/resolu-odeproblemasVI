/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Solicitacao;
import java.sql.SQLException;
import java.util.ArrayList;

public class SolicitacaoDAO extends Conexao {

    Solicitacao solicitacao;

    public boolean insert(int quantidade, String data, int produto, int almoxarifado, int almoxarife) {
        try {
            conectar();
            String sql = "INSERT INTO solicitacao VALUES (" + quantidade + ", '" + data + "', " + produto + ", " + almoxarifado + ", 1, " + almoxarife + ")";
            stm.executeUpdate(sql);
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setQuantidade(quantidade);
            solicitacao.setData(data);
            solicitacao.setProduto(produto);
            solicitacao.setAlmoxarifadoDestino(almoxarifado);
            solicitacao.setAlmoxarifeSolicitante(almoxarife);
            solicitacao.setStatus(1);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }

    public ArrayList<Solicitacao> selectAll(int almoxarifado) {

        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();

        try {
            conectar();
            String sql = "SELECT solicitacao.quantidade, solicitacao.data, status.situacao, item.quantidade, produto.descricao, almoxarifado.campus, solicitacao.idsolicitacao, produto.descricaocomplementar "
                    + "FROM public.solicitacao INNER JOIN item ON item.produto = solicitacao.produto "
                    + "INNER JOIN produto ON produto.idproduto = solicitacao.produto "
                    + "INNER JOIN status ON idstatus = solicitacao.status "
                    + "INNER JOIN almoxarife ON almoxarife.idalmoxarife = solicitacao.almoxarife "
                    + "INNER JOIN almoxarifado ON almoxarifado.idalmoxarifado = almoxarife.almoxarifado WHERE solicitacao.almoxarifado = " + almoxarifado + " AND item.estoque = " + almoxarifado + " AND solicitacao.status = 1";
            rs = stm.executeQuery(sql);

            Solicitacao solicitacao = null;

            while (rs.next()) {

                solicitacao = new Solicitacao();
                solicitacao.setQuantidade(rs.getInt(1));
                solicitacao.setData(rs.getString(2));
                solicitacao.setSituacao(rs.getString(3));
                solicitacao.setQuantidadeDisponivel(rs.getInt(4));
                solicitacao.setDescricao(rs.getString(5));
                solicitacao.setCampus(rs.getString(6));
                solicitacao.setId(rs.getInt(7));
                solicitacao.setDescricaoC(rs.getString(8));
                solicitacoes.add(solicitacao);
            }
            fechar();
            return solicitacoes;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto");
            fechar();
            return null;
        }
    }

    public ArrayList<Solicitacao> selectSolicitacoes(int almoxarife) {

        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();

        try {
            conectar();
            String sql = "SELECT solicitacao.quantidade, solicitacao.data, status.situacao, produto.descricao, almoxarifado.campus, solicitacao.idsolicitacao, produto.descricaocomplementar"
                    + " FROM public.solicitacao INNER JOIN produto ON produto.idproduto = solicitacao.produto"
                    + " INNER JOIN status ON idstatus = solicitacao.status"
                    + " INNER JOIN almoxarifado ON almoxarifado.idalmoxarifado = solicitacao.almoxarifado"
                    + " WHERE solicitacao.almoxarife = " + almoxarife + "";
            rs = stm.executeQuery(sql);

            Solicitacao solicitacao = null;

            while (rs.next()) {

                solicitacao = new Solicitacao();
                solicitacao.setQuantidade(rs.getInt(1));
                solicitacao.setData(rs.getString(2));
                solicitacao.setSituacao(rs.getString(3));
                solicitacao.setDescricao(rs.getString(4));
                solicitacao.setCampus(rs.getString(5));
                solicitacao.setId(rs.getInt(6));
                solicitacao.setDescricaoC(rs.getString(7));
                solicitacoes.add(solicitacao);
            }
            fechar();
            return solicitacoes;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto");
            fechar();
            return null;
        }
    }

    public boolean updateStatus(int solicitacaoSelecionada) {
        try {
            conectar();
            String sql = "UPDATE public.solicitacao"
                    + "   SET status=2"
                    + " WHERE idsolicitacao = " + solicitacaoSelecionada + "";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }
    
    public boolean updateStatusRecebido(int solicitacaoSelecionada) {
        try {
            conectar();
            String sql = "UPDATE public.solicitacao"
                    + "   SET status=5"
                    + " WHERE idsolicitacao = " + solicitacaoSelecionada + "";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }

    public boolean updateStatusNegado(int solicitacaoSelecionada) {
        try {
            conectar();
            String sql = "UPDATE public.solicitacao"
                    + "   SET status=3"
                    + " WHERE idsolicitacao = " + solicitacaoSelecionada + "";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }

}
