<<<<<<< HEAD

package entidades;

import java.util.List;
import main.java.com.sales.casosdeuso.*;
=======
package com.sales.entidades;

import java.util.List;

import com.sales.casosdeuso.VendaDTO;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf

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