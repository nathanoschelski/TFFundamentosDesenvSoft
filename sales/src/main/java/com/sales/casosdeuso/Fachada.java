<<<<<<< HEAD
package casosdeuso;

import entidades.*;
import interfaces.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
=======
package com.sales.casosdeuso;

import com.sales.entidades.Produto;
import com.sales.interfaces.ProdutoDAOException;
import com.sales.interfaces.ProdutoDAOImpl;

import java.util.List;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf

public class Fachada {

    private ProdutoDAO dao;
    
<<<<<<< HEAD
    public Fachada() throws ProdutoDAOException{
=======
    public Fachada() throws ProdutoDAOException {
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf
       try {
            dao = ProdutoDAOImpl.getInstance();
        } catch (ProdutoDAOException e) {
            throw new ProdutoDAOException("Falha de criação da fachada!", e);
        }
    }

    public Produto criarProduto(double costPrice, double transferPrice, String nome) throws ProdutoDAOException{

        Produto p = new Produto(costPrice, transferPrice, nome);
        System.out.println(p.toString());
        try {
            boolean ok = dao.criarProduto(p);
            if(ok) {
                return p;
            }
            return null;
       } catch (ProdutoDAOException e) {
            throw new ProdutoDAOException("Falha ao adicionar produto!", e);
        }
    }

    public List<Produto> buscarProdutos() throws Exception{
        try {
            return dao.getTodos();
        } catch (ProdutoDAOException e) {
            throw new ProdutoDAOException("Falha ao buscar produtos!", e);
        }
    }
}

