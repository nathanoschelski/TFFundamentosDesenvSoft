package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;
public interface VendaDAO {
        boolean criarVenda(VendaDTO v) throws ProdutoDAOException;
        public List<VendaDTO> getTodos();
}