package com.sales.casosdeuso;

public interface VendaDAO {
        boolean criarVenda(VendaDTO v) throws ProdutoDAOException;
}