public class Worksheet2 {
    public static void main(String[] args) {
        // the variables used for testing the methods
        int num = 12;
        double base = 2.0;
        int exp = 3;

        // Calling the methods
        System.out.println(reverseNum(num) + "\n");
        System.out.println(recursiveFactorial(num) + "\n");
        System.out.println(power(base, exp));
    }


    // Pre-condition: num is a positive integer
    // Post-condition: reverses the order of a given number
    public static String reverseNum(int num) {
        if (num != 0) {
            String s = "" + (num % 10);
            return (s + reverseNum(num / 10));
        }
        else
            return "";
    }


    // Pre-condition: n is a positive integer
    // Post-condition: the factorial will be returned
    public static int recursiveFactorial(int num) {
        if (num == 0)
            return 1;
        else
            return (num * recursiveFactorial(num - 1));
    }


    // Pre-condition: none
    // Post-condition: num is raised to exp, and so we get back a base raised to an exponent
    public static double power(double base, int exp) {
        if (base == 0)
            return 0;
        else if (exp == 0)
            return 1;
        else if (exp > 0)
            return base * power(base, exp - 1);
        else
            return 1 / power(base, -exp);
    }
}