package com.vaibhav1.codingexercise.company.facebook;

/**
 * Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task.
 * Tasks could be done in any order. Each task is done in one unit of time.
 * For each unit of time, the CPU could complete either one task or just be idle.
 *
 * However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array),
 * that is that there must be at least n units of time between any two same tasks.
 *
 * Return the least number of units of times that the CPU will take to finish all the given tasks.
 *
 * Example 1:
 *
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation:
 * A -> B -> idle -> A -> B -> idle -> A -> B
 * There is at least 2 units of time between any two same tasks.
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {

        int [] frequencies = new int [26];
        for(int i = 0; i<tasks.length; i++){
            frequencies[tasks[i]-'A']++;
        }

        int maxFrequency = 0;
        for(int f: frequencies){

            maxFrequency = Math.max(f, maxFrequency);
        }

        int numOfMaxFrequency = 0;
        for(int f : frequencies) {

            if(f == maxFrequency){
                numOfMaxFrequency++;
            }
        }


        int interval = (maxFrequency - 1) * (n + 1) + numOfMaxFrequency;

        return Math.max(tasks.length, interval);

    }
}
