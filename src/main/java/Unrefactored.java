import java.util.Arrays;
import java.util.LinkedList;

public class Unrefactored {
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        LinkedList<Integer> firstPart = new LinkedList<>();
        for (int i = p; i <= q; i++) {
            firstPart.add(A[i]);
        }
        LinkedList<Integer> secondPart = new LinkedList<>();
        for (int i = q + 1; i <= r; i++) {
            secondPart.add(A[i]);
        }

        LinkedList<Integer> mergedPartsResult = new LinkedList<>();
        while (firstPart.size() != 0 && secondPart.size() != 0) {
            if (firstPart.peekFirst() > secondPart.peekFirst()) {
                mergedPartsResult.add(secondPart.pollFirst());
            }
            else {
                mergedPartsResult.add(firstPart.pollFirst());
            }
        }
        mergedPartsResult.addAll(firstPart.size() == 0 ? secondPart : firstPart);

        for (int i = p; i <= r; i++) {
            A[i] = mergedPartsResult.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{100, 5, 2, 4, 13, 6, 1, 3, 2, -1, 6, 3, 10, 2, 0, 20, 1, 56, 100, 4};
        sort(A, 0, A.length - 1);
        System.out.println(Arrays.toString(A));
    }
}
