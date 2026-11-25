public class TowerOfHanoi {

    // Prints the moves needed to move n disks from source to destination.
    public static void solve(int n, char source, char auxiliary, char destination) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of disks cannot be negative.");
        }

        if (n == 0) {
            return;
        }

        solve(n - 1, source, destination, auxiliary);

        System.out.println("Move disk " + n + ": " + source + " -> " + destination);

        solve(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        solve(3, 'A', 'B', 'C');
    }
}
