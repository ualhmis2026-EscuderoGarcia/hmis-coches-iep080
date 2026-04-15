package ual.hmis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    void testTextoConEnie() {
        assertEquals("año", "año");
    }
    @Test
    void testMain() {
        App.main(new String[]{});
    }
    @Test
    void testConstructorApp() {
        App app = new App();
        assertNotNull(app);
    }
}