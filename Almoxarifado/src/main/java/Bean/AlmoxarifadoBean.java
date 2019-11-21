/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ItemDAO;
import Model.Item;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="almoxarifadoBean")
public class AlmoxarifadoBean {

    private ArrayList<Item> itens = new ArrayList<>();
    private ItemDAO item = new ItemDAO();
    private String produto;

    public void pesquisar() {
        itens = item.selectAll(produto);

    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public ItemDAO getItem() {
        return item;
    }

    public void setItem(ItemDAO item) {
        this.item = item;
    }

    public String getBuscaAll() {
        return produto;
    }

    public void setBuscaAll(String buscaAll) {
        this.produto = buscaAll;
    }

}
