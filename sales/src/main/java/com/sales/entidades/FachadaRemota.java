package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
        Produto p = fachada.criarProduto(costPrice,transferPrice, nome);
        return produto;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/buscar_produtos")
    public List<Produto> buscarProdutos(){
        List<Produto> produtos = fachada.buscarProdutos();
        return produtos; 
    }
}

