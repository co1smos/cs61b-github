import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator cc = new OffByN(5);

    @Test
    public void testOffByN() {
        assertTrue("1 is not right!", cc.equalChars('a', 'f'));
        assertTrue("2 is not right!", cc.equalChars('A', 'F'));
        assertTrue("3 is not right!", cc.equalChars('f', 'a'));
        assertFalse("4 is not right!", cc.equalChars('a', 'a'));
        assertFalse("5 is not right!", cc.equalChars('A', 'B'));
        assertFalse("6 is not right!", cc.equalChars('a', 'A'));
    }
}
