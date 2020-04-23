public class OffByN implements CharacterComparator {
    private int OffNumber;

    public OffByN(int n) {
        OffNumber = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return (x-y) == OffNumber || (y-x) == OffNumber;
    };
}
