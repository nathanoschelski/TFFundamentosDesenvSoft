import com.sales.casosdeuso.*;
import com.sales.entidades.*;
import com.sales.interfaces.*;

public class TesteCalculoEmpresa {

    public static void main(String args[]) {
        Fachada fachada; 
        fachada = new Fachada();
        double lucro; 
        lucro = fachada.CalculaLucro("Vendedor");
        System.out.println(lucro);
        
    }
}
