public class Worksheet3 {
    public static void main(String[] args) {
        // the variables used for testing the method
        int num = 6;

        // Calling the method
        System.out.println(fibonacci(num));
    }


    // Pre-condition: num is a positive integer
    // Post-condition: returns the fibonacci number of num
    public static int fibonacci (int num) {
        if (num == 0)
            return 0;
        else if (num == 1)
            return 1;
        else
            return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
