public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        int output = 0;
        while (x < 10) {
            output +=  x;
            System.out.print(output + " ");
            x = x + 1;
        }
    }
}