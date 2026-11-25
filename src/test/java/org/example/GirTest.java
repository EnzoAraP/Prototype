package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GirTest {

    @Test
    void cloneCopiaDadosEEnderecoSemCompartilharEndereco() {
        Gir original = new Gir("GIR-123", "João", 2000, 20, new Endereco("Rua A", 10));

        Gir clone = original.clone();
        clone.setRGN("GIR-456");
        clone.setDono("Maria");
        clone.setPreco(3000);
        clone.setProducaoLeiteMes(30);
        clone.getEndereco().setNumero(20);

        assertAll(
                () -> assertEquals("GIR-123", original.getRGN()),
                () -> assertEquals("João", original.getDono()),
                () -> assertEquals(2000, original.getPreco()),
                () -> assertEquals(20, original.getProducaoLeiteMes()),
                () -> assertEquals(10, original.getEndereco().getNumero()),
                () -> assertNotSame(original, clone),
                () -> assertNotSame(original.getEndereco(), clone.getEndereco()),
                () -> assertEquals(20, clone.getEndereco().getNumero())
        );
    }

    @Test
    void cloneMantemComportamentoDeConsumoIndependente() {
        Gir original = new Gir("GIR-123", "João", 2000, 20, new Endereco("Rua A", 10));

        Gir clone = original.clone();
        clone.venderConsumo();

        assertEquals(2000, original.getPreco());
        assertEquals(2400, clone.getPreco());
    }
}
