package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Fachada {

    private ProdutoDAO dao;
    private VendaDAO daoVenda;
    
    private ProdutoDAOImpl ProdutoDAOImpl; 
    private Produto Produto; 
    private ProdutoDAOException ProdutoDAOException;
    private VendaDTO VendaDTO; 
    private CalculoLucroFactory CalculoLucroFactory;
    private CalculoLucro CalculoLucro;
    private VendaDAOImpl VendaDAOImpl;    


    @Autowired
    public Fachada(ProdutoDAOImpl ProdutoDAOImpl, VendaDAOImpl VendaDAOImpl,  Produto Produto, ProdutoDAOException ProdutoDAOException, VendaDTO VendaDTO, CalculoLucroFactory CalculoLucroFactory, CalculoLucro CalculoLucro) {

        this.ProdutoDAOImpl = ProdutoDAOImpl; 
        this.Produto = Produto; 
        this.ProdutoDAOException = ProdutoDAOException;
        this.VendaDTO = VendaDTO; 
        this.CalculoLucroFactory = CalculoLucroFactory;
        this.CalculoLucro = CalculoLucro;

       try {
            dao = ProdutoDAOImpl.getInstance();
            daoVenda = VendaDAOImpl.getInstance();
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

    public VendaDTO venderProduto(double margem, Produto produto){

        double salesPrice = (1 + margem) * produto.getTransferPrice();
        VendaDTO v = new VendaDTO(margem, salesPrice, produto);
        System.out.println(v.toString()); 

        try {
            boolean ok = daoVenda.criarVenda(v);
            if(ok) {
                return v;
            }
            else 
                return null;
       } catch (Exception e) {
           System.out.println("Falha ao adicionar venda!");
        }
        return v;
    }
    
    public List<VendaDTO> buscarVendas() throws Exception{
        try {
            return daoVenda.getTodos();
        } catch (Exception e) {
            throw new Exception("Falha ao buscar vendas!", e);
        }
    }

    public double calcularLucro(String tipo){
        
        double lucro;
        List<VendaDTO> vendas = new ArrayList<VendaDTO>();
        
        try {
            vendas = buscarVendas();
           } catch (Exception e) {
             System.out.println("Fachada>CalculuaLucro> Falha ao pegar lista de vendas!" + e);
        }
          
        CalculoLucroFactory calculoFactory = new CalculoLucroFactory();
        CalculoLucro calculo = calculoFactory.criarCalculoLucro(tipo); 
    
        lucro = calculo.calcular(vendas); 
        return lucro; 
}
}

