package flik;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlickTest {
    @Test
    public void equalTest() {
        int a = 128;
        int b = 128;
        assertTrue(Flik.isSameNumber(a, b));
    }

    @Test
    public void notequalTest() {
        int a = 2;
        int b = 3;
        assertFalse(Flik.isSameNumber(a, b));
    }
}
