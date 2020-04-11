import java.util.HashSet;
import static java.lang.System.*;

public class SearchingTasks {

    public static int firstIndexOf(int[] array, int key) {
        return firstIndexOf(array, key, 0, array.length - 1, -1);
    }

    private static int firstIndexOf(int[] array, int key, int leftSize, int rightSize, int result) {
        if (leftSize <= rightSize) {
            int midIndex = (leftSize + rightSize) / 2;
            if (array[midIndex] == key) {
                return firstIndexOf(array, key, leftSize, midIndex - 1, midIndex);
            } else if (array[midIndex] < key) {
                return firstIndexOf(array, key, midIndex + 1, rightSize, result);
            } else {
                return firstIndexOf(array, key, leftSize, midIndex - 1, result);
            }
        }
        return result;
    }

    public static int secondIndexOf(int[] array, int key) {
        int firstIndex = firstIndexOf(array, key, 0, array.length - 1, -1);
        return array[firstIndex] == array[firstIndex + 1] ? firstIndex + 1 : -1;
    }

    public static int lastIndexOf(int[] array, int key) {
        int leftSize = 0, rightSize = array.length - 1, result = -1;
        while (leftSize <= rightSize) {
            int midIndex = (leftSize + rightSize) / 2;
            if (array[midIndex] == key) {
                result = midIndex;
                leftSize = midIndex + 1;
            } else if (array[midIndex] < key) {
                leftSize = midIndex + 1;
            } else {
                rightSize = midIndex - 1;
            }
        }
        return result;
    }

    public static boolean hasSum(int[] array, int sum) {
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            int checkSumOfPairs = sum - array[i];
            if (set.contains(checkSumOfPairs) && checkSumOfPairs != array[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 6, 6, 6, 8, 14};
        int key = 6, sum = 14;
        out.println(firstIndexOf(array, key));
        out.println(secondIndexOf(array, key));
        out.println(lastIndexOf(array, key));
        out.println(hasSum(array, sum));
    }
}