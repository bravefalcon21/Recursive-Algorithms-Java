public class BinarySearch {

    // Searches for target in a sorted array.
    // Returns its index, or -1 if it is not found.
    public static int search(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] == target) {
            return mid;
        }

        if (target < array[mid]) {
            return search(array, target, left, mid - 1);
        }

        return search(array, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 11, 15};

        System.out.println(search(numbers, 11, 0, numbers.length - 1));
        System.out.println(search(numbers, 6, 0, numbers.length - 1));
    }
}
