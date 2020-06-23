
package main.java.com.sales.casosdeuso;
import main.java.com.sales.casosdeuso.*;
import main.java.com.sales.entidades.*;
import java.util.List;
import main.java.com.sales.*;

public interface ProdutoDAO {
        boolean criarProduto(Produto p);
        public List<Produto> getTodos();
}