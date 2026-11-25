package org.example;

public interface Animal {
    String getDono();
    void setDono(String dono);
    double getPreco();
    void setPreco(double preco);
    Animal clone();
}
