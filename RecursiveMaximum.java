public class RecursiveMaximum {

    // Finds the largest value in a non-empty part of the array.
    public static int findMaximum(int[] array, int left, int right) {
        if (left == right) {
            return array[left];
        }

        int mid = left + (right - left) / 2;

        int leftMaximum = findMaximum(array, left, mid);
        int rightMaximum = findMaximum(array, mid + 1, right);

        return Math.max(leftMaximum, rightMaximum);
    }

    public static void main(String[] args) {
        int[] numbers = {-8, -3, -12, -1, -5};

        System.out.println(findMaximum(numbers, 0, numbers.length - 1));
    }
}
