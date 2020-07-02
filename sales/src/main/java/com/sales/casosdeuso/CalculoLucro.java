package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;
public interface CalculoLucro {

    public double calcular(List<VendaDTO> vendas);
    
}