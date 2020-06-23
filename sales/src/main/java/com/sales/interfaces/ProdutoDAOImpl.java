

package main.java.com.sales.interfaces;

import main.java.com.sales.casosdeuso.*;
import main.java.com.sales.entidades.*;
import main.java.com.sales.interfaces.*;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoDAOImpl implements ProdutoDAO {
    private static ProdutoDAOImpl ref;
    
    public static ProdutoDAOImpl getInstance() {
        if (ref == null)
            ref = new ProdutoDAOImpl();
        return ref;
    }
    
    private ProdutoDAOImpl() throws ProdutoDAOException {
        try {
             Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException ex) {
            throw new ProdutoDAOException("JdbcOdbDriver not found!!");
        }
        
        /*
        try {
            createDB();
        } catch (Exception ex) {
            System.out.println("Problemas para criar o banco: "+ex.getMessage());
            System.exit(0);
        }
                */
    }
    
    private static void createDB() {
       // System.out.println("Vem aqui");
        try {
            Connection con = DriverManager.getConnection("jdbc:derby:derbyDB;create=true");
            Statement sta = con.createStatement();
            
            String sql = "CREATE TABLE Produto ("
                    + "Id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "Nome VARCHAR(100) NOT NULL,"
                    + "CostPrice DOUBLE,"
                    + "TransferPrice DOUBLE"
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
    public boolean adicionar(Produto p) {
        try {
            Connection con = getConnection();
            
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO Produto (Nome, CostPrice, TransferPrice) VALUES (?,?,?)" //                             1        2         3            4          5             6
                    );
            stmt.setString(1, p.getNome());
            stmt.setDouble(2, p.getCostPrice());
            stmt.setDouble(3, p.getTransferPrice());
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
    
    @Override
    public List<Produto> getTodos() throws ProdutoDAOException {
        try {
            Connection con = getConnection();
            Statement stmt = con.createStatement();
            ResultSet resultado = stmt.executeQuery("SELECT * FROM Produto");
            List<Produto> lista = new ArrayList<Produto>();
            while(resultado.next()) {
                String nome = resultado.getString("Nome");
                double costPrice = resultado.getDouble("CostPrice");
                double transferPrice = resultado.getDouble("TransferPrice");
                Produto p = new Produto(nome, costPrice, transferPrice);
                lista.add(p);
            }
            return lista;
        } catch (SQLException ex) {
            throw new ProdutoDAOException("Falha ao buscar produtos.", ex);
        }    }
}
