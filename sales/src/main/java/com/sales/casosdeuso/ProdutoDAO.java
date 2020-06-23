
package main.java.com.sales.casosdeuso;

import main.java.com.sales.entidades.*;
import main.java.com.sales.interfaces.*;
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p) throws ProdutoDAOException;
        public List<Produto> getTodos() throws ProdutoDAOException;
}