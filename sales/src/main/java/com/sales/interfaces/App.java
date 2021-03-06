package com.sales.interfaces;
import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App {


    public static void main(String args[]) {
        Fachada fachada; 
        
        List<Produto> produtos = new ArrayList<Produto>();
        List<VendaDTO> vendas = new ArrayList<VendaDTO>();

        fachada = new Fachada();

        //CADASTRA PRODUTOS

        Produto tv = fachada.criarProduto(1350.99, 1500, "TV LCD");
        Produto geladeira = fachada.criarProduto(800, 850, "Geladeira"); 
        Produto nike = fachada.criarProduto(159.00, 227.00, "nike");
        
        
        //CRIA UMA VENDA 
        VendaDTO venda = fachada.venderProduto(0.2, tv);
        System.out.println("venda> " + venda.toString());

        //LISTA PRODUTOS E VENDAS CADASTRADOS
        try {
            produtos = fachada.buscarProdutos();
            vendas = fachada.buscarVendas();
        } catch (Exception e) {
        //    throw new ProdutoDAOException("Falha ao buscar produtos!", e);
            System.out.println(e);
            //TODO: handle exception
       }
        for (Produto p : produtos){
            System.out.println("listaProdutos>" + p.toString());
        }  
        
        for (VendaDTO v : vendas){
            System.out.println("listaVendas>" +v.toString());
        }  
        
        //CALCULA LUCRO DA EMPRESA E DO VENDEDOR
        double lucroEmpresa;
        double lucroVendedor; 
        lucroVendedor = fachada.CalculaLucro("Vendedor");
        lucroEmpresa = fachada.CalculaLucro("Empresa"); 
        System.out.println("Lucro da empresa é: " + lucroEmpresa);
        System.out.println("Lucro do vendedor é: " + lucroVendedor); 
        
        
    }   
}