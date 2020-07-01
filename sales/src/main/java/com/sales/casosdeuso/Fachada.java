package main.java.com.sales.casosdeuso;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Fachada {

    private ProdutoDAO dao;
    
    public Fachada() throws ProdutoDAOException{
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

