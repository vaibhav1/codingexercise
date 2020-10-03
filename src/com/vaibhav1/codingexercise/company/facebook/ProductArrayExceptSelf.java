package com.vaibhav1.codingexercise.company.facebook;

import java.util.Arrays;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int [] prod = new int[nums.length];

        Arrays.fill(prod, 1);

        int temp = 1;
        for(int i = 0; i<prod.length; i++){
            prod[i] = temp;
            temp *= nums[i];
        }

        temp = 1;
        for(int i = nums.length-1; i>=0; i--){
            prod[i] *= temp;
            temp *= nums[i];
        }

        return prod;
    }


}
