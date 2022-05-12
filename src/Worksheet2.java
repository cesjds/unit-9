public class Worksheet2 {
    public static void main(String[] args) {
        // num is the variable used for testing the methods
        int num = 12;

        // Calling the methods
        System.out.println(reverseNum(num) + "\n");
        System.out.println(recursiveFactorial(num) + "\n");
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


    // Pre-condition: n is a positive integer
    // Post-condition: the factorial will be returned
    public static int recursiveFactorial (int num) {
        if (num == 0)
            return 1;
        else
            return (num * recursiveFactorial(num - 1));
    }
}
