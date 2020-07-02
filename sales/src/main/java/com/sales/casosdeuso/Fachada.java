package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Fachada {

    private ProdutoDAO dao;
    private VendaDAO vendaDao;
    
    public Fachada() {
    
    //throws ProdutoDAOException{
       try {
            dao = ProdutoDAOImpl.getInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Produto criarProduto(double costPrice, double transferPrice, String nome){
        
        Produto p = null;

        try { 
            p = new Produto(costPrice, transferPrice, nome);
            System.out.println("produto>" + p.toString());
            boolean ok = dao.criarProduto(p);
            if(!ok) {
                p = null;
            }
       } catch (Exception e) {
           System.out.println("Falha ao adicionar produto!" + e);
        }
        return p;

    }

    public List<Produto> buscarProdutos() throws Exception{
        try {
            return dao.getTodos();
        } catch (ProdutoDAOException e) {
            throw new ProdutoDAOException("Falha ao buscar produtos!", e);
        }
    }

    public VendaDTO venderProduto(double margem, Produto produto){
        
        VendaDTO v = null; 
        System.out.println(margem + " - " + produto.getNome());
        
        
        try {
            double salesPrice = (1 + margem) * produto.getTransferPrice();
            System.out.println("salesPrice: " + salesPrice);
            v = new VendaDTO(margem, salesPrice, produto);
            System.out.println("Vendeu aqui: " + v.toString());
            boolean ok = vendaDao.criarVenda(v);
            if(!ok) {
                System.out.println("retornou ok aqui: " + v.toString());
                v = null;
            }
       } catch (Exception e) {
           System.out.println("Falha ao adicionar venda!" + e);
        }
        return v; 

    } 
}

