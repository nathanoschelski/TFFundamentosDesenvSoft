package com.sales.interfaces;

import com.sales.entidades.*;
import com.sales.casosdeuso.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
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
        
        
        
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
        //    System.exit(0);
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
            System.out.println("AQUI");
            Connection connection = getConnection();
            System.out.println("ALI");
            
            PreparedStatement stmt2 = connection.prepareStatement(
                    "INSERT INTO Venda (Produto, Margem, SalesPrice) VALUES (?,?,?)"
                    );
            System.out.println("ACOLA");
            Produto p = v.getProduto();
            System.out.println("VendaDAOImpl>criarVenda>Nome " + p.getNome());
            stmt2.setString(1, p.getNome());
            stmt2.setDouble(2, v.getMargem());
            stmt2.setDouble(3, v.getSalesPrice());
            System.out.println(stmt2.getWarnings());
            
            int ret = stmt2.executeUpdate();
            System.out.println(ret);
            connection.close();
            return (ret>0);
        } catch (SQLException ex) {
            System.out.println("VendaDAOImpl> Erro adicionar");
            throw new ProdutoDAOException("VendaDAOImpl>  Falha ao adicionar.", ex);
        }
    }
    
     @Override
    public List<VendaDTO> getTodos(){
        
        ProdutoDAO produtoDao = null;
        List<VendaDTO> lista = new ArrayList<VendaDTO>();
        
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Venda");
            try {
                produtoDao = ProdutoDAOImpl.getInstance();
                } catch (Exception e) {
        }
             
            
            while(resultado.next()) {
                String nomeProduto = resultado.getString("Produto");
                Produto p = null; 
                
                 try {
                    p = produtoDao.getProdutoByNome(nomeProduto);
                } catch (Exception e) {
                    System.out.println(e);
                }
                 
                double margem = resultado.getDouble("Margem");
                double salesPrice = resultado.getDouble("SalesPrice");
                VendaDTO v = new VendaDTO(margem, salesPrice, p);
                
                System.out.println("AQUIIII333 ----" + v.toString());
                
                lista.add(v);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Falha ao buscar vendas." + ex);
        }    
        return lista;
    }
        
    
    
        
}