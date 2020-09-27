package com.vaibhav1.codingexercise;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example:
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int result = 0;

        int left = 0;
        int right = height.length-1;

        while(left < right){

            if(leftMax < rightMax){
                result += leftMax - height[left];
                left ++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                result += rightMax - height[right];
                right --;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return result;
    }
}
