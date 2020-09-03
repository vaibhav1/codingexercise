package com.vaibhav1.codingexercise;

import java.util.Stack;

public class FruitsInBasket {

    public int totalFruit(int[] tree) {

        if(tree == null || tree.length ==0){
            return 0;
        }

        int lastFruit = -1;
        int secondLastFruit = -1;
        int max = Integer.MIN_VALUE;
        int currentMax = 0;

        int lastFruitCount = 0;

        for(int fruit: tree){

            if(fruit == lastFruit || fruit == secondLastFruit){
                currentMax +=1;
            } else{
                currentMax = lastFruitCount + 1;
            }

            if(fruit == lastFruit){
                lastFruitCount += 1;
            } else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currentMax);

        }

        return max;
    }

    public static void main(String[] args) {

    }
}
