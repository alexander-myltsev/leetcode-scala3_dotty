package main;

public class Solution0_java {
    public static int repeatedNTimes(int[] a) {   
        for (int i = 0; i < a.length; ++i) {
            for (int j = 1; j < 4 && i + j < a.length; ++j) {
                if (a[i] == a[i + j]) {
                    return a[i];
                }
            }
        }
        throw new IllegalArgumentException();
    }
}
