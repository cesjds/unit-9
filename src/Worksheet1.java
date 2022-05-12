public class Worksheet1 {
    public static void main(String[] args) {

        int n = 4;

        cheers1(n);
        System.out.println();
        cheers2(n);
        System.out.println();
        cheers3(n);
        System.out.println();
        asterisks(n);
        System.out.println();
        mystery(n);
        System.out.println();
        reverseNum(n);

    }

    public static void cheers1(int n) {
        if (n <= 1)
            System.out.println("Hurrah");
        else {
            System.out.println("Hip");
            cheers1(n-1);
        }
    }

    public static void cheers2(int n) {
        if (n > 1) {
            System.out.println("Hip");
            cheers2(n-1);
        }
        else
            System.out.println("Hurrah");
    }

    public static void cheers3(int n) {
        if (n > 1) {
            System.out.println("Hip");
            cheers3(n - 1);
            System.out.println("Hip");
        }
        else {
            System.out.println("Hurrah");
        }
    }

    public static void asterisks(int n) {
        if (n >= 1) {
            System.out.println('*');
            asterisks(n - 1);
            System.out.println('!');
        }
    }

    public static void mystery(int n) {
        if (n <= 0)
            return;
        for (int i = 0; i < n; i ++)
            System.out.print("-");
        for (int i = 0; i < n; i ++)
            System.out.print("+");
        System.out.println();
        mystery(n - 1);
    }

    public static void reverseNum(int num) {
        if (num != 0) {
            System.out.print( num % 10 );
            reverseNum( num / 10);
        }
    }
}
