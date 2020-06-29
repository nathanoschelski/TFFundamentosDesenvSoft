
package casosdeuso;

import entidades.*;
import interfaces.*;
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p) throws ProdutoDAOException;
        public List<Produto> getTodos() throws ProdutoDAOException;
}