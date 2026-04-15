package ual.hmis;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void testMain() {
        Main.main(new String[]{});
    }
    @Test
    void testConstructorMain() {
        Main main = new Main();
        assertNotNull(main);
    }
}