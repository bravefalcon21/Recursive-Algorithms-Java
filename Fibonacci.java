public class Fibonacci {

    // Simple recursive Fibonacci implementation.
    // It is intentionally not optimized, so large inputs take a long time.
    public static long fibonacci(int n) {
        if (n < 0 || n > 92) {
            throw new IllegalArgumentException("Enter a number from 0 to 92.");
        }

        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
