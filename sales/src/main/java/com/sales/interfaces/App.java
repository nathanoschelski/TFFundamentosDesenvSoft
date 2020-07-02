package com.sales.interfaces;
import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App {


    public static void main(String args[]) {
//    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada; 
        List<Produto> produtos = new ArrayList<Produto>();

        fachada = new Fachada();

        //cadastra produtos

        //Produto tv = fachada.criarProduto(1350.99, 1500, "TV LCD");
        //Produto geladeira = fachada.criarProduto(800, 850, "Geladeira"); 
        Produto tenis = fachada.criarProduto(199.00, 217.00, "Tenis");

        VendaDTO venda = fachada.venderProduto(0.3, tenis);
        System.out.println("venda" + venda.toString());


        
        //lista produtos cadastrados
        try {
            produtos = fachada.buscarProdutos();
        } catch (Exception e) {
        //    throw new ProdutoDAOException("Falha ao buscar produtos!", e);
            System.out.println(e);
            //TODO: handle exception
       }
        for (Produto p : produtos){
            System.out.println("listaProdutos>" + p.toString());
        }  
    }   
}