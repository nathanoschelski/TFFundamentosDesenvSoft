package casosdeuso;

import java.util.List;
import entidades.*;

public class VendaDTO {

    private Produto produto;
    private double margem;
    private double salesPrice;

    public VendaDTO(double margem, double salesPrice, Produto produto) {
        this.margem = margem;
        this.salesPrice = salesPrice;
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getMargem() {
        return margem;
    }

    public void setMargem(double margem) {
        this.margem = margem;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String toString() {
        return "VendaDTO [produto=" + produto.getNome() + ", margem=" + margem + ", salesPrice=" + salesPrice + "]";
    }


}