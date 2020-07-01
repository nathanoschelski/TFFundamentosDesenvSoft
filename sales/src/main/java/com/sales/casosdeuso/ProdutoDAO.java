<<<<<<< HEAD

package main.java.com.sales.casosdeuso;

=======
package com.sales.casosdeuso;

import com.sales.entidades.Produto;
import com.sales.interfaces.ProdutoDAOException;
>>>>>>> 7efa8ec7b80232b5166ef7a1a679a3d5d7e98abf
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p) throws ProdutoDAOException;
        public List<Produto> getTodos() throws ProdutoDAOException;
}