package com.sales.interfaces;
import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta_vendas")
public class FachadaRemota {

    private Fachada sFachada;

    @Autowired
    public FachadaRemota(Fachada sFachada) {
        this.sFachada = sFachada;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/cria_produto")
    public Produto criarProduto(@RequestParam double costPrice, @RequestParam  double transferPrice, @RequestParam String nome){
        Produto produto = sFachada.criarProduto(costPrice,transferPrice, nome);
        return produto;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_produtos")
    public List<Produto> buscarProdutos(){
        try {
            List<Produto> produtos = sFachada.buscarProdutos();
           return produtos; 
        } catch (Exception e) {
            throw new IllegalArgumentException("Aluno nao encontrado");
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/calcula_lucro")
    public double calculaLucro(@RequestParam String tipo){
       double lucro = sFachada.calcularLucro(tipo);
        return lucro; 
    } 
}