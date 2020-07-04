import com.sales.casosdeuso.*;
import com.sales.entidades.*;
import com.sales.interfaces.*;

public class TesteCalculoEmpresa {

    public static void main(String args[]) {
        Fachada fachada; 
        fachada = new Fachada();
        double lucroEmpresa;
        double lucroVendedor; 
        lucroVendedor = fachada.CalculaLucro("Vendedor");
        lucroEmpresa = fachada.CalculaLucro("Empresa"); 
        System.out.println("Lucro da empresa é: " + lucroEmpresa);
        System.out.println("Lucro do vendedor é: " + lucroVendedor); 
        
    }
}
