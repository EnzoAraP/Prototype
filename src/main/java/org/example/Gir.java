package org.example;

public class Gir implements Vaca {
    private String rgn;
    private String dono;
    private double preco;
    private int producaoLeiteMes;
    private Endereco endereco;

    public Gir(String rgn, String dono, double preco, int producaoLeiteMes, Endereco endereco) {
        this.rgn = rgn;
        this.dono = dono;
        setPreco(preco);
        this.producaoLeiteMes = producaoLeiteMes;
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
    public int getProducaoLeiteMes() { return producaoLeiteMes; }
    public void setProducaoLeiteMes(int producaoLeiteMes) { this.producaoLeiteMes = producaoLeiteMes; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }

    public void venderConsumo() { setPreco(preco + producaoLeiteMes * 20); }

    @Override
    public Gir clone() {
        try {
            Gir clone = (Gir) super.clone();
            clone.endereco = endereco == null ? null : endereco.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
