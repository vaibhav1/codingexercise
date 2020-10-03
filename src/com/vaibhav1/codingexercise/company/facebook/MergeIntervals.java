package com.vaibhav1.codingexercise.company.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 *
 * Example 2:
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        for(int [] interval : intervals){

            if(results.size() == 0 || results.get(results.size()-1).get(1) < interval[0]){
                List<Integer> newInterval = new ArrayList<Integer>(); //create a new List interval
                newInterval.add(interval[0]); //add start
                newInterval.add(interval[1]); // add end
                results.add(newInterval); // add the new interval as List

            } else {
                List<Integer> last = results.remove(results.size()-1); // remove the last added interval
                int end = last.remove(1); // remove the end time from the last interval
                last.add(Math.max(end, interval[1])); // replace the end time with max end time
                results.add(last); // add back the interval with updated end time.
            }
        }


        //cnovert the result interval list to 2D array for returning
        int [][] finalResult = new int[results.size()][2];
        int count = 0;
        for(List<Integer> interval: results){
            finalResult[count][0] = interval.get(0);
            finalResult[count][1] = interval.get(1);
            count++;
        }

        return finalResult;

    }
}
