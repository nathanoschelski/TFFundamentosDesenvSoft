
package main.java.com.sales.casosdeuso;

import com.sales.entidades.Produto;
import com.sales.interfaces.ProdutoDAOException;
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p) throws ProdutoDAOException;
        public List<Produto> getTodos() throws ProdutoDAOException;
}