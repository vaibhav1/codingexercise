package com.vaibhav1.codingexercise.company.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */
public class SubArraySumEqualsK {

    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        map.put(0, 1);
        int sum = 0;
        int result = 0;

        for(int i=0; i<nums.length; i++){

            sum += nums[i];

            if(map.containsKey(sum - k)){
                result += map.get(sum - k);
            }

            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }

        return result;

    }
}
