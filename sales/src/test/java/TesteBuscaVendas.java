
import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TesteBuscaVendas {


    public static void main(String args[]) {
//    public static void main(String args[]) throws ProdutoDAOException {
        Fachada fachada; 
        List<VendaDTO> vendas = new ArrayList<VendaDTO>();
        fachada = new Fachada();
        
        //Produto scarpinP = fachada.criarProduto(159.00, 227.00, "scarpinP");
        
        

        //VendaDTO venda = fachada.venderProduto(0.3, scarpinP);
        //System.out.println("venda> " + venda.toString());


        
        //lista produtos cadastrados
        try {
            //produtos = fachada.buscarProdutos();
            vendas = fachada.buscarVendas();
        } catch (Exception e) {
        //    throw new ProdutoDAOException("Falha ao buscar produtos!", e);
            System.out.println(e);
            //TODO: handle exception
       }
        //for (Produto p : produtos){
        //    System.out.println("listaProdutos>" + p.toString());
        //}  
        
        for (VendaDTO v : vendas){
            System.out.println("listaVendas>" +v.toString());
        }  
        
    }   
}