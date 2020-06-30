package com.sales.interfaces;

public interface VendaDAO {
        boolean criarVenda(VendaDTO v) throws ProdutoDAOException;
}