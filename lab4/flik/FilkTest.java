package flik;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FilkTest {
    @Test
    public void minIntegerTest() {
        assertEquals(Flik.isSameNumber(-128, -128), true);
        assertTrue(Flik.isSameNumber(128, 128));
    }
}
