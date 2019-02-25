import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = new int[]{ 5, 3, 2, 8, 1, 4 };
        int[] sorted = sortArray(original);
        int[] finalArray = createOddSortedArray(original.clone(), sorted);

        System.out.println("Final: ");
        printArray(finalArray);
    }

    private static int[] createOddSortedArray(int[] original, int[] sorted) {
        int position = 0;
        int swapPosition = 0;

        while (position < original.length) {
            position = FindNextOdd(sorted, position);
            swapPosition = FindNextOdd(original, swapPosition);

            if (position == -1) break;

            original[swapPosition] = sorted[position];
            position++;
            swapPosition++;
        }

        return original;
    }


    private static int FindNextOdd(int[] sorted, int position) {
        for (int i = position; i < sorted.length; i++) {
            if (sorted[i] % 2 == 1) {
                return i;
            }
        }

        return -1;
    }

    private static void printArray(int[] sorted) {
        for (var i : sorted) {
            System.out.print(i + ",");
        }
        System.out.println();
    }

    private static int[] sortArray(int[] array) {
        int[] sorted = array.clone();
        Arrays.sort(sorted);

        return sorted;
    }
}



