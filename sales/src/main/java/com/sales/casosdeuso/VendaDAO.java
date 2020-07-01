package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
public interface VendaDAO {
        boolean criarVenda(VendaDTO v) throws ProdutoDAOException;
}