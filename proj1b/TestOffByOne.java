import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.

    //static CharacterComparator cc = new OffByOne();

    @Test
    public void testOffByOne() {
        assertTrue("1 is not right!", offByOne.equalChars('a', 'b'));
        assertTrue("2 is not right!", offByOne.equalChars('b', 'a'));
        assertTrue("3 is not right!", offByOne.equalChars('B', 'C'));
        assertFalse("4 is not right!", offByOne.equalChars('a', 'd'));
        assertFalse("5 is not right!", offByOne.equalChars('a', 'B'));
        assertFalse("6 is not right!", offByOne.equalChars('a', 'A'));
    }
}
