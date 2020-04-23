public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> CharDeque = new LinkedListDeque<Character>();
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            CharDeque.addLast(word.charAt(i));
        }
        return CharDeque;
    }


    public boolean isPalindrome(String word) {
        //Deque WordDeque = wordToDeque(word); this manner also works
        Deque<Character> WordDeque = wordToDeque(word);
        //int wordLength = word.length();
        while (WordDeque.size() > 1) {
            if(WordDeque.removeFirst() != WordDeque.removeLast()) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> WordDeque = wordToDeque(word);
        while (WordDeque.size() > 1) {
            Character a = WordDeque.removeFirst();
            Character b = WordDeque.removeLast();
            if(!cc.equalChars(a, b)) return false;
        }
        return true;
    }
}
