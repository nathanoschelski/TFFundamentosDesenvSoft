package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;
public class CalculoLucroVendedor implements CalculoLucro {
    
    @Override
    public double calcular(List<VendaDTO> vendas){
                
        double lucro = 0;
        double extra = 0; 
        
        for (VendaDTO v : vendas){
           
            Produto p = v.getProduto();
            
           //calcula comissao extra pela margem de venda
           if (v.getMargem() >= 0.1 && v.getMargem() < 0.2) {
               extra = 0.01; 
               System.out.println(extra);
           }
           else if(v.getMargem() >= 0.2 && v.getMargem() < 0.3){
               extra = 0.03; 
               System.out.println(extra);
           }
           else if(v.getMargem() >= 0.3 ){
                extra = 0.06; 
                System.out.println(extra);
           }
           
           //se for produto do mes adiciona 5% de comissao
           if(p.isProdutoDoMes()){
                extra += 0.05; 
                System.out.println(extra);
           }
           
            //se for venda for mmaior que 1000 adiciona 2% de comissao
           if(v.getSalesPrice() > 1000){
                extra += 0.02; 
                System.out.println(extra);
           }
           
           System.out.println("final: " + extra + " Margem " + v.getMargem() );
           lucro += (v.getSalesPrice() *  extra);
        }  
            
        return lucro;
    }
}