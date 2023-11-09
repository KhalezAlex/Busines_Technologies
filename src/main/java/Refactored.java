import java.util.Arrays;
import java.util.LinkedList;

public class Refactored {
    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        LinkedList<Integer> firstPart = getPartListFromArr(arr, start, mid);
        LinkedList<Integer> secondPart = getPartListFromArr(arr, mid + 1, end);
        LinkedList<Integer> result = new LinkedList<>(mergeParts(firstPart, secondPart));
        for (int i = start; i <= end; i++) {
            arr[i] = result.pollFirst();
        }
    }

    private static LinkedList<Integer> getPartListFromArr(int[] arr, int start, int end) {
        LinkedList<Integer> part = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            part.add(arr[i]);
        }
        return part;
    }

    private static LinkedList<Integer> mergeParts(LinkedList<Integer> first, LinkedList<Integer> second) {
        LinkedList<Integer> result = new LinkedList<>();
        while (first.size() != 0 && second.size() != 0) {
            if (first.peekFirst() > second.peekFirst()) {
                result.add(second.pollFirst());
            }
            else {
                result.add(first.pollFirst());
            }
        }
        result.addAll(first.size() == 0 ? second : first);
        return result;
    }

    public static void main(String[] args) {
        int[] A = new int[]{100, 5, 2, 4, 13, 6, 1, 3, 2, -1, 6, 3, 10, 2, 0, 20, 1, 56, 100, 4};
        sort(A, 0, A.length - 1);
        System.out.println("51: " + Arrays.toString(A));
    }
}
