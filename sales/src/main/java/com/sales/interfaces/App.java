package com.sales.interfaces;

import com.sales.casosdeuso.Fachada;
import com.sales.entidades.Produto;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada;
        List<Produto> produtos = new ArrayList<Produto>();

        fachada = new Fachada();


        //cadastra produtos ee
        Produto prod = fachada.criarProduto(1350, 2000, "Pow");

//        Produto tv = fachada.criarProduto('1350'    , '1500', 'TV LCD');
//        Produto geladeira = fachada.criarProduto('800', '850', 'Geladeira'); 
//        Produto sofa = fachada.criarProduto('1999.00', '2300.00', 'Sofa');
        
        //lista produtos cadastrados
        try {
            produtos = fachada.buscarProdutos();
        } catch (Exception e) {
            //TODO: handle exception
        }
        for (Produto p : produtos){
            System.out.println(p.toString());
        }  
    }   
}