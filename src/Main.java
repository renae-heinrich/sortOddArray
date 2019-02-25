import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = {3, 6, 2, 7, 1};
        int[] sorted = sortArray(original);
        reinsert(original, sorted);

    }

    private static int[] reinsert(int[] original, int[] sorted) {
        int position = 0;
        int swapPosition = 0;
        while (position < original.length) {
            position = FindNextSwap(sorted, position);
            swapPosition = FindNextOdd(original, swapPosition);

            if (position == -1) break;


            sorted[swapPosition] = original[position];
            position++;
            swapPosition++;
        }


        return original;

    }

    private static int FindNextSwap(int[] sorted, int position) {
        System.out.print("Sorted: ");
        printArray(sorted);
        for(int i = position; i < sorted.length; i++) {
            if (!(sorted[i] % 2 == 0)) {
                return i;
            }
        }


        return -1;
    }

    private static int FindNextOdd(int[] original, int position) {
        System.out.print("Original: ");
        printArray(original);
        for(int i = position; i < original.length; i++){
            if(!(original[i] % 2 == 0)){
                return i;
            }
        }

        // find the next position in the original array to swap into.
        return 0;
    }

    private static void printArray(int[] sorted) {
        for(var i : sorted){
            System.out.print(i + ",");
        }
        System.out.println();
    }

    static int[] sortArray(int[] array) {
        int[] sorted = array.clone();
        Arrays.sort(sorted);

        return sorted;
    }
}



