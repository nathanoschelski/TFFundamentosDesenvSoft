package com.sales.interfaces;

import com.sales.casosdeuso.VendaDTO;

public interface VendaDAO {
        boolean criarVenda(VendaDTO v) throws ProdutoDAOException;
}