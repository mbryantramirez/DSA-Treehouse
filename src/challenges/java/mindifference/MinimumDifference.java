package challenges.java.mindifference;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 10};
        System.out.println(naiveMinDifference(arr));
        System.out.println(minDifference(arr));
    }

    private static int naiveMinDifference(int[] arr) {
        int lastMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff < lastMin) {
                    lastMin = diff;
                }
            }
        }
        return lastMin;
    }

    private static int minDifference(int[] arr) {
        int minimum = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            minimum = Math.min(minimum, (arr[i] - arr[i - 1]));
        }
        return minimum;
    }
}
