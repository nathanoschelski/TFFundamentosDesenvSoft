/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sales.entidades.*;
import com.sales.casosdeuso.*;
import com.sales.interfaces.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TesteBuscaProdPorNome {
    
    public static void main(String args[]) {
        
        ProdutoDAO produtoDao;
         try {
            produtoDao = ProdutoDAOImpl.getInstance();
            Produto p = produtoDao.getProdutoByNome("nike");
            System.out.println(p.toString());

        } catch (Exception e) {
            System.out.println(e);
        }
        
    
}
