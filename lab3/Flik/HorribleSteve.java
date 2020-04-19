public class HorribleSteve {
    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        //why the output is 128 instead of 500
        //see the link below
        //https://blog.csdn.net/weixin_38361347/article/details/81916620
        System.out.println("i is " + i);
    }
}
