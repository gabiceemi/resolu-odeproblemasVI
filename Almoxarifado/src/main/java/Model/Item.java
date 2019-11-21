package Model;

import java.util.ArrayList;

public class Item {
    
    private ArrayList<Item> itens = new ArrayList<>();
    private int quantidade;
    private Almoxarifado almoxarifado;
    private Produto produto;
    
    public Item(){
        
    }

    public Item(Almoxarifado almoxarifado, Produto produto) { 
        this.almoxarifado = almoxarifado; 
        this.produto = produto; 
    }
    
    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Almoxarifado getAlmoxarifado() {
        return almoxarifado;
    }

    public void setAlmoxarifado(Almoxarifado almoxarifado) {
        this.almoxarifado = almoxarifado;
    }
  
}
