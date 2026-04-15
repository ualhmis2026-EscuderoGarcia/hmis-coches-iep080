package ual.hmis;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CocheTest {

    private Coche coche;

    @BeforeEach
    void setUp() {
        coche = new Coche("Toyota", "Corolla", 2020, 18000);
    }

    @Test
    void testGetMarca() {
        assertEquals("Toyota", coche.getMarca());
    }

    @Test
    void testSetMarca() {
        coche.setMarca("Honda");
        assertEquals("Honda", coche.getMarca());
    }

    @Test
    void testGetModelo() {
        assertEquals("Corolla", coche.getModelo());
    }

    @Test
    void testSetModelo() {
        coche.setModelo("Civic");
        assertEquals("Civic", coche.getModelo());
    }

    @Test
    void testGetAño() {
        assertEquals(2020, coche.getAño());
    }

    @Test
    void testSetAño() {
        coche.setAño(2023);
        assertEquals(2023, coche.getAño());
    }

    @Test
    void testGetPrecio() {
        assertEquals(18000, coche.getPrecio());
    }

    @Test
    void testSetPrecio() {
        coche.setPrecio(20000);
        assertEquals(20000, coche.getPrecio());
    }

    @Test
    void testToString() {
        assertEquals("Coche [marca=Toyota, modelo=Corolla, año=2020, precio=18000]", coche.toString());
    }

    @Test
    void testConstructorDefecto() {
        Coche c = new Coche();
        assertNotNull(c);
    }

    // Ramas del equals
    @Test
    void testEqualsConElMismo() {
        assertTrue(coche.equals(coche)); // this == obj
    }

    @Test
    void testEqualsConNull() {
        assertFalse(coche.equals(null)); // obj == null
    }

    @Test
    void testEqualsConOtraClase() {
        assertFalse(coche.equals("un string")); // getClass() != obj.getClass()
    }

    @Test
    void testEqualsIgual() {
        Coche otro = new Coche("Toyota", "Corolla", 2020, 18000);
        assertTrue(coche.equals(otro));
    }

    @Test
    void testEqualsDistinto() {
        Coche otro = new Coche("Honda", "Civic", 2021, 20000);
        assertFalse(coche.equals(otro));
    }
    @Test
    void testEqualsDistintoAño() {
        Coche otro = new Coche("Toyota", "Corolla", 2021, 18000);
        assertFalse(coche.equals(otro));
    }

    @Test
    void testEqualsDistintoPrecio() {
        Coche otro = new Coche("Toyota", "Corolla", 2020, 99999);
        assertFalse(coche.equals(otro));
    }

    @Test
    void testEqualsDistintaMarca() {
        Coche otro = new Coche("Honda", "Corolla", 2020, 18000);
        assertFalse(coche.equals(otro));
    }

    @Test
    void testEqualsDistintoModelo() {
        Coche otro = new Coche("Toyota", "Civic", 2020, 18000);
        assertFalse(coche.equals(otro));
    }
}