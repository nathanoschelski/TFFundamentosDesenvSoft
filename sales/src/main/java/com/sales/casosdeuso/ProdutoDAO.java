
package main.java.com.sales.casosdeuso;
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p);
        public List<Produto> getTodos();
}