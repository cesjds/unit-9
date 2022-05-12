public class Worksheet2 {
    public static void main(String[] args) {
        // num is the variable used for testing the methods
        int num = 123;

        // Calling the methods
        System.out.println(reverseNum(num));
        System.out.println();
    }


    // Pre-condition: num is a positive integer
    // Post-condition: reverses the order of a given number
    public static String reverseNum (int num) {
        if (num != 0) {
            String s = "" + (num % 10);
            return (s + reverseNum(num / 10));
        }
        else
            return "";
    }
}
