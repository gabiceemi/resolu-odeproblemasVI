/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Almoxarifado;
import Model.Produto;
import Model.RequisicaoMensal;
import java.sql.SQLException;
import java.util.ArrayList;

public class RequisicaoMensalDAO extends Conexao {

    public ArrayList<RequisicaoMensal> buscarTodos() {

        ArrayList<RequisicaoMensal> requisicoes = new ArrayList<>();

        try {
            conectar();
            String sql = "SELECT DISTINCT requisicao.id, almoxarifado.campus, produto.descricao, produto.descricaocomplementar, requisicao.qtsolicitada,\n"
                    + "status.situacao, item.quantidade FROM requisicao INNER JOIN almoxarifado ON requisicao.almoxarifado = almoxarifado.idalmoxarifado\n"
                    + "INNER JOIN produto ON produto.idproduto = requisicao.produto\n"
                    + "INNER JOIN status ON requisicao.status = status.idstatus\n"
                    + "INNER JOIN item ON item.estoque = 1\n"
                    + "ORDER BY almoxarifado.campus ASC";
            rs = stm.executeQuery(sql);

            Produto produto;
            Almoxarifado almoxarifado;
            RequisicaoMensal rm;
            

            while (rs.next()) {

                produto = new Produto();
                almoxarifado = new Almoxarifado();
                rm = new RequisicaoMensal();
                rm.setId(rs.getInt(1));
                almoxarifado.setCampus(rs.getString(2));
                produto.setDescricao(rs.getString(3));
                produto.setDescricaoComplementar(rs.getString(4));
                rm.setQtdSolicitada(rs.getInt(5));
                rm.setStatus(rs.getString(6));
                rm.setQtdDisp(rs.getInt(7));

                rm.setAlmoxarifado(almoxarifado);
                rm.setProduto(produto);
                requisicoes.add(rm);

            }
            fechar();
            return requisicoes;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar");
            fechar();
            return null;
        }
    }
    public boolean updateStatus(int requisicaoSelecionada) {
        try {
            conectar();
            String sql = "UPDATE public.requisicao"
                    + "   SET status=2"
                    + " WHERE idsolicitacao = " +requisicaoSelecionada + "";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }

    public boolean updateStatusNegado(int requisicaoSelecionada) {
        try {
            conectar();
            String sql = "UPDATE public.requisicao"
                    + "   SET status=3"
                    + " WHERE idsolicitacao = " + requisicaoSelecionada + "";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }
}
