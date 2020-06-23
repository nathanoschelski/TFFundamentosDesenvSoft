package com.sales.entidades;

public class Produto {

    private double costPrice;
    private double transferPrice;
    private boolean produtoDoMes;
    private String nome;

    public Produto(double costPrice, double transferPrice, String nome) {
        this.costPrice = costPrice;
        this.transferPrice = transferPrice;
        this.nome = nome;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getTransferPrice() {
        return transferPrice;
    }

    public void setTransferPrice(double transferPrice) {
        this.transferPrice = transferPrice;
    }

    public boolean isProdutoDoMes() {
        return produtoDoMes;
    }

    public void setProdutoDoMes(boolean produtoDoMes) {
        this.produtoDoMes = produtoDoMes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", costPrice=" + costPrice + ", produtoDoMes=" + produtoDoMes
                + ", transferPrice=" + transferPrice + "]";
    }

    
    
    

    
}