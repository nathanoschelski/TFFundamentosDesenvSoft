
package main.java.com.sales.entidades;

import java.util.List;

public class Vendedor {

    private String nome; 
    private List<VendaDTO> vendas;

    public Vendedor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<VendaDTO> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaDTO> vendas) {
        this.vendas = vendas;
    }


}