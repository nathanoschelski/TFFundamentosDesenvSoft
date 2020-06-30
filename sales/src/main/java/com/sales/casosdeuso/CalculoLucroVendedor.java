package com.sales.casosdeuso;

public class CalculoLucroVendedor implements CalculoLucro {
    
    @Override
    public double calcular(VendaDTO venda){
        
        double lucro = 100;
        return lucro;
        
    }
}