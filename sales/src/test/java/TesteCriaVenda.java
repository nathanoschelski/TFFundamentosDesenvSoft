
import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TesteCriaVenda {


    public static void main(String args[]) {
//    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada; 
        fachada = new Fachada();
        
        Produto havaianas = fachada.criarProduto(89.00, 100.00, "havaianas");
        
        VendaDTO venda = fachada.venderProduto(0.3, havaianas);
        System.out.println("venda> " + venda.toString());
    }   
}