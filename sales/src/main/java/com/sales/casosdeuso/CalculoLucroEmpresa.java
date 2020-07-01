package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
public class CalculoLucroEmpresa implements CalculoLucro {
    
    @Override
    public double calcular(VendaDTO venda){
        
        double lucro = 1500;
        return lucro;
        
    }
}