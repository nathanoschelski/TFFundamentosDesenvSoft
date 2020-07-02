
package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;

public interface ProdutoDAO {
        boolean criarProduto(Produto p) throws ProdutoDAOException;
        public List<Produto> getTodos() throws ProdutoDAOException;
        public Produto getProdutoByNome(String nome) throws ProdutoDAOException;
}