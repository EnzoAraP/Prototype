package org.example;

public class Nelore implements Vaca {
    private String rgn;
    private String dono;
    private double preco;
    private int peso;
    private Endereco endereco;

    public Nelore(String rgn, String dono, double preco, int peso, Endereco endereco) {
        this.rgn = rgn;
        this.dono = dono;
        setPreco(preco);
        this.peso = peso;
        this.endereco = endereco;
    }

    @Override public String getRGN() { return rgn; }
    @Override public void setRGN(String rgn) { this.rgn = rgn; }
    @Override public String getDono() { return dono; }
    @Override public void setDono(String dono) { this.dono = dono; }
    @Override public double getPreco() { return preco; }
    @Override public void setPreco(double preco) {
        if (preco < 0) throw new IllegalArgumentException("Preço deve ser maior ou igual a 0");
        this.preco = preco;
    }
    public int getPeso() { return peso; }
    public void setPeso(int peso) { this.peso = peso; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public void venderConsumo() { setPreco(peso * 148.0); }

    @Override
    public Nelore clone() {
        try {
            Nelore clone = (Nelore) super.clone();
            clone.endereco = endereco == null ? null : endereco.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
