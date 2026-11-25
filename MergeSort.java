import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        int[] temporary = new int[array.length];
        sortRange(array, temporary, 0, array.length - 1);
    }

    private static void sortRange(int[] array, int[] temporary,
                                  int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;

        sortRange(array, temporary, left, mid);
        sortRange(array, temporary, mid + 1, right);
        merge(array, temporary, left, mid, right);
    }

    private static void merge(int[] array, int[] temporary,
                              int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temporary[k++] = array[i++];
            } else {
                temporary[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temporary[k++] = array[i++];
        }

        while (j <= right) {
            temporary[k++] = array[j++];
        }

        for (int index = left; index <= right; index++) {
            array[index] = temporary[index];
        }
    }

    public static void main(String[] args) {
        int[] numbers = {9, 3, 7, 3, -2};

        sort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
