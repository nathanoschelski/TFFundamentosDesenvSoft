package com.sales.interfaces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.sales.casosdeuso.*;
import com.sales.entidades.*;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class VendaDAOImpl implements VendaDAO {
    private static VendaDAOImpl ref;
    
    public static VendaDAOImpl getInstance() throws ProdutoDAOException{
        if (ref == null)
            ref = new VendaDAOImpl();
        return ref;
    }
    
    private VendaDAOImpl() throws ProdutoDAOException{
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new ProdutoDAOException("JdbcOdbDriver not found!!");
        }
    }
    
    private static void createDB() throws ProdutoDAOException {
       // System.out.println("Vem aqui");
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            
            String sql = "CREATE TABLE Venda (" 
                    + "Id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "Produto VARCHAR(100) NOT NULL,"
                    + "Margem DOUBLE," 
                    +"SalesPrice DOUBLE"
                    + ")";
            
            sta.executeUpdate(sql);
            sta.close();
            con.close();
        } catch (SQLException ex) {
            throw new ProdutoDAOException(ex.getMessage());
        }
    }
        
    
    private static Connection getConnection() throws SQLException {
        //derbyDB sera o nome do diretorio criado localmente
        return DriverManager.getConnection("jdbc:derby:derbyDB");
    }
    
    @Override
    public boolean criarVenda(VendaDTO v) throws ProdutoDAOException {
        try {
            Connection con = getConnection();
            
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Venda (IdProduto, Margem, SalesPrice) VALUES (?,?,?)" //                             1        2         3            4          5             6
                    );
            Produto p = v.getProduto();
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, v.getMargem());
            stmt.setDouble(3, p.getSalesPrice());
            System.out.println(stmt.getWarnings());
            
            int ret = stmt.executeUpdate();
            System.out.println(ret);
            con.close();
            return (ret>0);
        } catch (SQLException ex) {
            System.out.println("falhando");
            throw new ProdutoDAOException("Falha ao adicionar.", ex);
        }
    }
}