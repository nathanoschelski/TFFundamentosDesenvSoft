package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;

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