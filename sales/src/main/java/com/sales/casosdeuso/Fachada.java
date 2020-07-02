package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Fachada {

    private ProdutoDAO dao;
    
    public Fachada() {
    
    //throws ProdutoDAOException{
       try {
            dao = ProdutoDAOImpl.getInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Produto criarProduto(double costPrice, double transferPrice, String nome){

        try { 
            Produto p = new Produto(costPrice, transferPrice, nome);
            System.out.println(p.toString());
            boolean ok = dao.criarProduto(p);
            if(ok) {
                return p;
            }
            return null;
       } catch (Exception e) {
           System.out.println("Falha ao adicionar produto! e");
        }
        return null;

    }

    public List<Produto> buscarProdutos() throws Exception{
        try {
            return dao.getTodos();
        } catch (ProdutoDAOException e) {
            throw new ProdutoDAOException("Falha ao buscar produtos!", e);
        }
    }
}

