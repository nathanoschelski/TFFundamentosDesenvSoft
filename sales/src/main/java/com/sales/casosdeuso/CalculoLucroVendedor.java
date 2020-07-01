package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
public class CalculoLucroVendedor implements CalculoLucro {
    
    @Override
    public double calcular(VendaDTO venda){
        
        double lucro = 100;
        return lucro;
        
    }
}