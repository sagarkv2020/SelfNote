package leetcode;

import java.util.*;


/*

Q1.
There are Infinite number hosts available, but host can run only 1 process Given an input a 2d array, where each item of the array consists of startTime and endTime a time.
Calculate minimum no of hosts required for all the processes given in the input.
input -> {{0,30), {15,20), {20,30)}
exp output -> 3


Q2.
Given 2 tree with head pointers, Determine if those tree are mirror images or not.

 */
public class DSA_2dArray_MinHosts {

    public static int minHosts(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // PriorityQueue to store end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first interval
        minHeap.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            // If the current start time is >= earliest end time, reuse the host
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Assign current interval to a host (either reused or new)
            minHeap.add(intervals[i][1]);
        }

        // Size of the heap tells the number of hosts required
        return minHeap.size();
    }

    public static void main(String[] args) {


        int[][] intervals = { {0, 30}, {15, 20}, {20, 30} };  //will give 3
       // int[][] intervals = { {0, 30}, {15, 20}, {20, 30}, {25, 30}, {30,60}, {30,45}, {35, 40}, {35,50}};  // --> Will give 4
        int result = minHosts(intervals);
        System.out.println("Minimum number of hosts required: " + result);
    }
}