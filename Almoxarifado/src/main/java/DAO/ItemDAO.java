/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Almoxarifado;
import Model.Item;
import Model.Produto;
import Model.Solicitacao;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAO extends Conexao {

    Solicitacao solicitacao;

    public ArrayList<Item> selectAll(String busca) {

        ArrayList<Item> itens = new ArrayList<Item>();

        try {
            conectar();
            String sql = "SELECT produto.idproduto, produto.descricao, produto.descricaocomplementar, almoxarifado.campus, item.quantidade FROM item INNER JOIN produto ON item.produto = produto.idproduto INNER JOIN almoxarifado ON item.estoque = almoxarifado.estoque WHERE produto.descricao = '" + busca + "'";
            rs = stm.executeQuery(sql);

            Item item = null;
            Produto pro = null;
            Almoxarifado almo = null;

            while (rs.next()) {

                item = new Item();
                pro = new Produto();
                almo = new Almoxarifado();

                pro.setCodigo(rs.getInt(1));
                pro.setDescricaoComplementar(rs.getString(3));
                pro.setDescricao(rs.getString(2));
                item.setQuantidade(rs.getInt(5));
                almo.setCampus(rs.getString(4));

                item.setProduto(pro);
                item.setAlmoxarifado(almo);

                itens.add(item);
            }
            fechar();
            return itens;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto");
            fechar();
            return null;
        }
    }

    public Solicitacao select(int codigo, String campus, int quantidade) {
        try {
            conectar();
            String sql = "SELECT produto.idproduto, idalmoxarifado, item.quantidade FROM item INNER JOIN produto ON item.produto = produto.idproduto INNER JOIN almoxarifado ON item.estoque = almoxarifado.estoque WHERE item.produto = " + codigo + " AND almoxarifado.campus = '" + campus + "' AND item.quantidade >= " + quantidade + "";
            rs = stm.executeQuery(sql);

            Solicitacao solicitacao = null;

            while (rs.next()) {
                solicitacao = new Solicitacao();
                solicitacao.setProduto(rs.getInt(1));
                solicitacao.setAlmoxarifadoDestino(rs.getInt(2));
            }
            fechar();
            return solicitacao;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return null;
        }
    }

    public int itemCentral(String desc, String descComp) {
        try {
            conectar();
            String sql = "SELECT item.quantidade FROM item INNER JOIN estoque ON estoque.idestoque = item.estoque INNER JOIN produto ON produto.idproduto = item.produto INNER JOIN almoxarifado ON almoxarifado.estoque = estoque.idestoque WHERE produto.descricao = '" + desc + "' AND produto.descricaocomplementar = '" + descComp + "' AND almoxarifado.tipo = 1";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                int itemCentral = rs.getInt(1);
                return itemCentral;
            }
            fechar();
            return 0;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }

    public boolean updateQuantidade(int quantidade, int almoxarifadoDestino, int produto) {
         try {
            conectar();
            String sql = "UPDATE public.item"
                    + "   SET quantidade=quantidade-"+quantidade+""
                    + " WHERE estoque = " + almoxarifadoDestino + " AND produto = " + produto +"";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }
    
    public boolean updateQuantidadeRecebida(int quantidade, int almoxarifado, int produto) {
         try {
            conectar();
            String sql = "UPDATE public.item"
                    + "   SET quantidade=quantidade+ "+quantidade+""
                    + " WHERE estoque = " + almoxarifado + " AND produto = " + produto +"";
            stm.executeUpdate(sql);
            fechar();
            return true;
        } catch (SQLException e) {
            fechar();
            return false;
        }
    }

}
