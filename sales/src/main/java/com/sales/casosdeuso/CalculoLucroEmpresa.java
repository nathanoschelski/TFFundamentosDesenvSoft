package com.sales.casosdeuso;

public class CalculoLucroEmpresa implements CalculoLucro {
    
    @Override
    public double calcular(VendaDTO venda){
        
        double lucro = 1500;
        return lucro;
        
    }
}