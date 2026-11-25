public class Factorial {

    // long can store factorial values from 0! through 20!.
    public static long factorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Enter a number from 0 to 20.");
        }

        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
