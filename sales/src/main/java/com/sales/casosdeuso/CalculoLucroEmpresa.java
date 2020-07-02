package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;
public class CalculoLucroEmpresa implements CalculoLucro {
    
    @Override
    public double calcular(List<VendaDTO> vendas){
        
        double lucro = 0; 
        
        for (VendaDTO v : vendas){
           Produto p = v.getProduto();
           lucro += (v.getSalesPrice() - p.getCostPrice());
        }  
            
        return lucro;
        
    }
}