package com.vaibhav1.codingexercise.company.facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
 * You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
 *
 * BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
 * BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
 *
 * Example 1:
 * Input: mat = [[0,0],[1,1]]
 * Output: 0
 *
 *
 * Example 2:
 * Input: mat = [[0,0,0,1],[0,0,1,1],[0,1,1,1]]
 * Output: 1
 */

class BinaryMatrix {

    int [][] binary;

     public int get(int row, int col){
        return binary[row][col];
     }
     public List<Integer> dimensions(){
        List<Integer> dimension =  new ArrayList<Integer>();
        return dimension;
     }
}
public class LeftmostColumnWithAtleastAOne {

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        int row = binaryMatrix.dimensions().get(0);
        int col = binaryMatrix.dimensions().get(1);

        int result = Integer.MAX_VALUE;

        int currentCol = col - 1;
        int currentRow = row - 1;

        while(currentRow >= 0 && currentCol >= 0){

            if(binaryMatrix.get(currentRow, currentCol) == 1){

                result = currentCol;

                currentCol--;

            } else {
                currentRow-- ;
            }

        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

}
