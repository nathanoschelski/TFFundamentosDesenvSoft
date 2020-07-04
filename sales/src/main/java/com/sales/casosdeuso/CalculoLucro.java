package com.sales.casosdeuso;
import com.sales.entidades.*;
import com.sales.interfaces.*;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CalculoLucro {

    public double calcular(List<VendaDTO> vendas);
    
}