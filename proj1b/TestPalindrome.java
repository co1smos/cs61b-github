import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testisPalindrome() {
        boolean Result1 = palindrome.isPalindrome("dsfsodfh");
        //boolean Result1_exp = false;
        boolean Result2 = palindrome.isPalindrome("noon");
        //boolean Result2_exp = true;

        assertFalse("result1 is not right",Result1);
        assertTrue("result2 is not right",Result2);

        CharacterComparator cc = new OffByOne();
        boolean Result3 = palindrome.isPalindrome("Aaa", cc);
        //boolean Result1_exp = false;
        boolean Result4 = palindrome.isPalindrome("flake", cc);
        //boolean Result2_exp = true;

        assertFalse("result3 is not right",Result3);
        assertTrue("result4 is not right",Result4);
    }

}
