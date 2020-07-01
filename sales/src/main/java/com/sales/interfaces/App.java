<<<<<<< HEAD
package interfaces;

import casosdeuso.*;
import entidades.*;
import interfaces.*;
=======
package com.sales.interfaces;

import com.sales.casosdeuso.Fachada;
import com.sales.entidades.Produto;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App {

<<<<<<< HEAD

    public static void main(String args[]) {
//    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada; 
=======
    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf
        List<Produto> produtos = new ArrayList<Produto>();

        fachada = new Fachada();

<<<<<<< HEAD
        //cadastra produtos

        Produto tv = fachada.criarProduto(1350.99, 1500, "TV LCD");
        Produto geladeira = fachada.criarProduto(800, 850, "Geladeira"); 
        Produto sofa = fachada.criarProduto(1999.00, 2300.00, "Sofa");
=======

        //cadastra produtos ee
        Produto prod = fachada.criarProduto(1350, 2000, "Pow");

//        Produto tv = fachada.criarProduto('1350'    , '1500', 'TV LCD');
//        Produto geladeira = fachada.criarProduto('800', '850', 'Geladeira'); 
//        Produto sofa = fachada.criarProduto('1999.00', '2300.00', 'Sofa');
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf
        
        //lista produtos cadastrados
        try {
            produtos = fachada.buscarProdutos();
        } catch (Exception e) {
<<<<<<< HEAD
            throw new ProdutoDAOException("Falha ao buscar produtos!", e);
=======
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf
            //TODO: handle exception
        }
        for (Produto p : produtos){
            System.out.println(p.toString());
        }  
    }   
}