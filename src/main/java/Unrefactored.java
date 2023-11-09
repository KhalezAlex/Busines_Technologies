import java.util.Arrays;
import java.util.LinkedList;

public class Main3 {
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        LinkedList<Integer> firstPart = new LinkedList<>();
        for (int i = start; i <= mid; i++) {
            firstPart.add(arr[i]);
        }
        LinkedList<Integer> secondPart = new LinkedList<>();
        for (int i = mid + 1; i <= end; i++) {
            secondPart.add(arr[i]);
        }

        LinkedList<Integer> result = new LinkedList<>();
        while (firstPart.size() != 0 && secondPart.size() != 0) {
            if (firstPart.peekFirst() > secondPart.peekFirst()) {
                result.add(secondPart.pollFirst());
            }
            else {
                result.add(firstPart.pollFirst());
            }
        }
        result.addAll(firstPart.size() == 0 ? secondPart : firstPart);

        for (int i = start; i <= end; i++) {
            arr[i] = result.pollFirst();
        }
    }

    public static void main(String[] args) {
        int[] A = new int[]{100, 5, 2, 4, 13, 6, 1, 3, 2, -1, 6, 3, 10, 2, 0, 20, 1, 56, 100, 4};
        sort(A, 0, A.length - 1);
        System.out.println("51: " + Arrays.toString(A));
    }
}
