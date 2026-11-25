package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NeloreTest {

    @Test
    void cloneCopiaDadosEEnderecoSemCompartilharEndereco() {
        Nelore original = new Nelore("NEL-123", "João", 5000, 600, new Endereco("Rua B", 15));

        Nelore clone = original.clone();
        clone.setRGN("NEL-456");
        clone.setDono("Maria");
        clone.setPreco(7000);
        clone.setPeso(800);
        clone.getEndereco().setLogradouro("Rua C");

        assertAll(
                () -> assertEquals("NEL-123", original.getRGN()),
                () -> assertEquals("João", original.getDono()),
                () -> assertEquals(5000, original.getPreco()),
                () -> assertEquals(600, original.getPeso()),
                () -> assertEquals("Rua B", original.getEndereco().getLogradouro()),
                () -> assertNotSame(original, clone),
                () -> assertNotSame(original.getEndereco(), clone.getEndereco()),
                () -> assertEquals("Rua C", clone.getEndereco().getLogradouro())
        );
    }

    @Test
    void cloneMantemComportamentoDeConsumoIndependente() {
        Nelore original = new Nelore("NEL-123", "João", 5000, 600, new Endereco("Rua B", 15));

        Nelore clone = original.clone();
        clone.venderConsumo();

        assertEquals(5000, original.getPreco());
        assertEquals(118400, clone.getPreco());
    }

    @Test
    void naoAceitaPrecoNegativo() {
        Nelore nelore = new Nelore("NEL-123", "João", 0, 600, new Endereco("Rua B", 15));

        assertThrows(IllegalArgumentException.class, () -> nelore.setPreco(-1));
    }
}
