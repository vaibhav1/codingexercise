package com.vaibhav1.codingexercise;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {

        int [] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for(int i = 1; i <= amount; i++){

            for(int j=0; j < coins.length; j++){

                if(coins[j] <= i){

                    int coin = dp[i-coins[j]];


                    if(coin != Integer.MAX_VALUE && coin+1<dp[i] ){
                        dp[i] = coin+1;
                    }



                }
            }
        }
        if(dp[amount] > amount){
            return -1;
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int [] coins = {2};
        int amount = 3;

        CoinChange change = new CoinChange();
        System.out.println(change.coinChange(coins, amount));

    }
}


