import main.java.com.sales.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class App {

    public static void main(String args[]) {
        Fachada fachada; 
        List<Produto> produtos = new ArrayList<Produto>();

        fachada = new Fachada();


        //cadastra produtos ee
        Produto prod = fachada.criarProduto(1350, 2000, "Pow");

//        Produto tv = fachada.criarProduto('1350'    , '1500', 'TV LCD');
//        Produto geladeira = fachada.criarProduto('800', '850', 'Geladeira'); 
//        Produto sofa = fachada.criarProduto('1999.00', '2300.00', 'Sofa');
        
        //lista produtos cadastrados
        produtos = fachada.buscarProdutos();
        for (Produto p : produtos){
            System.out.println(p.toString());
        }  
    }   
}