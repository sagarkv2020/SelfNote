package acn;

import java.util.Arrays;

public class SeqvsParallelStream {
    public static void main(String[] args) {
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) arr[i] = i;

// Using stream
        long start1 = System.currentTimeMillis();
        int[] squares1 = Arrays.stream(arr)
                                .map(x -> x * x)
                                .toArray();
        long end1 = System.currentTimeMillis();
        System.out.println("Stream time: " + (end1 - start1) + " ms");



// Using parallelStream
        long start2 = System.currentTimeMillis();
        int[] squares2 = Arrays.stream(arr)
                                .parallel()
                                .map(x -> x * x)
                                .toArray();
        long end2 = System.currentTimeMillis();
        System.out.println("ParallelStream time: " + (end2 - start2) + " ms");
    }
}