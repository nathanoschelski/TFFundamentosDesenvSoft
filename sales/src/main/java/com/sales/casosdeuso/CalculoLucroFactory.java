package com.sales.casosdeuso;

public class CalculoLucroFactory {
    
    //devolve um CalculoLucro, dependendo do tipo
    public CalculoLucro criarCalculoLucro(String Tipo){
        
        CalculoLucro calculo;
    
        if(Tipo == "Empresa"){
            calculo = new CalculoLucroEmpresa();
        }
        else {
            calculo = new CalculoLucroVendedor();
        }
        
        return calculo;
    }  
}