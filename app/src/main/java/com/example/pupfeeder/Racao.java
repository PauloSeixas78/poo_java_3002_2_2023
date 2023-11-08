package com.example.pupfeeder;

public class Racao {
    private int id;
    private String marca;
    private int quantidade;
    private String tipo;
    private String porte;

    public Racao(int id, String marca, int quantidade, String tipo, String porte) {
        this.id = id;
        this.marca = marca;
        this.quantidade = quantidade;
        this.tipo = tipo;
        this.porte = porte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }
}
