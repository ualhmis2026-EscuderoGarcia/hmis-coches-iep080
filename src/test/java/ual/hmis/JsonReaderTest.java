package ual.hmis;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	@Test
	void testLeerCochesJSON() {
		String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@Test
	void testLeerCochesJSONprimero() {
		String ruta = "data/coches.json";
		Coche primero = new Coche ("Toyota", "Corolla", 2020, 18000);
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue (primero.equals(coches[0]));
		assertTrue (coches[0].equals(primero));
	}
	@Test
	void testLeerCochesJSONarchivoInexistente() {
    	Coche[] coches = JsonReader.leerCochesJSON("ruta/inexistente.json");
    	assertNull(coches);
	}
	@Test
	void testConstructorJsonReader() {
		JsonReader jr = new JsonReader();
		assertNotNull(jr);
	}
}
