package com.vaibhav1.codingexercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solving RedMart's coding problem: Skiing in Singapore
 * @author vshukla
 *
 */
public class SkiingInSingapore {
	
	private static int[][] map; 
	private static int row; 
	private static int column; 
	
	// store the path length of each coordinate
	private static int[][] path;
	
	// store the drop value of each coordinate
	private static int[][] drop;

	public static void main(String[] args) throws Exception {
		
		String fileName = "/Users/vshukla/GitPersonal/codingexercise/src/com/vaibhav1/codingexercise/map.txt";
		loadData(fileName);

		// update the path matrix and drop matrix using dfs search
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int[] tmp = dfsForPathAndDrop(i, j);
				path[i][j] = tmp[0];
				drop[i][j] = map[i][j] - map[tmp[1]][tmp[2]];
			}
		}

		int[] maxXY = new int[2]; 
		int maxPath = -1; //  maxPath
		int maxDrop = -1; //  maxDrop

		// find the maxPath and maxDrop in the path matrix and drop matrix
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (path[i][j] > maxPath) { 
					maxPath = path[i][j];
					maxDrop = drop[i][j];
					maxXY[0] = i; 
					maxXY[1] = j;
				}
				if (path[i][j] == maxPath) { 
					if (drop[i][j] > maxDrop) { 
						maxDrop = drop[i][j];
						maxXY[0] = i; 
						maxXY[1] = j;
					}
				}
			}
		}
		
		// print max path and max drop
		System.out.println("Maximal Path is: " + maxPath + "\nMaximal Drop is: " + maxDrop);

	}

	// load data from the txt file
	public static void loadData(String fileName) throws Exception {
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String lineTxt;
		if ((lineTxt = br.readLine()) != null) {
			String[] str = lineTxt.split(" ");
			
			row = Integer.parseInt(str[0]);
			
			column = Integer.parseInt(str[1]);
			map = new int[row][column];
			path = new int[row][column];
			drop = new int[row][column];
		}
		int i = 0;
		// the following 1000 lines are the 1000 integers of each line of the matrix
		while ((lineTxt = br.readLine()) != null) {
			int j = 0;
			String[] str = lineTxt.split(" ");
			for (String s : str) {
				map[i][j++] = Integer.parseInt(s);
			}
			i++;
		}
		br.close();
	}

	// computing the maximal path length and its drop
	public static int[] dfsForPathAndDrop(int i, int j) {
		int[] pathAndDrop = { 0, i, j }; 
		int[] curPathAndDrop = new int[2];
		
		if (j > 0 && map[i][j] > map[i][j - 1]) {
			curPathAndDrop = dfsForPathAndDrop(i, j - 1);
			if (curPathAndDrop[0] > pathAndDrop[0]) 
				
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the down direction
		if (j < (column - 1) && map[i][j] > map[i][j + 1]) {
			curPathAndDrop = dfsForPathAndDrop(i, j + 1);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the left direction
		if (i > 0 && map[i][j] > map[i - 1][j]) {
			curPathAndDrop = dfsForPathAndDrop(i - 1, j);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the right direction
		if (i < (row - 1) && map[i][j] > map[i + 1][j]) {
			curPathAndDrop = dfsForPathAndDrop(i + 1, j);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		pathAndDrop[0]++; 
		return pathAndDrop;
	}

	// record the path of the maximal path length
	public static List<Integer> dfsForPath(int x, int y) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> curPathList = new ArrayList<Integer>();
		// search from the up direction
		if (y > 0 && map[x][y] > map[x][y - 1]) {
			curPathList = dfsForPath(x, y - 1);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the down direction
		if (y < (column - 1) && map[x][y] > map[x][y + 1]) {
			curPathList = dfsForPath(x, y + 1);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the left direction
		if (x > 0 && map[x][y] > map[x - 1][y]) {
			curPathList = dfsForPath(x - 1, y);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the right direction
		if (x < (row - 1) && map[x][y] > map[x + 1][y]) {
			curPathList = dfsForPath(x + 1, y);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		list.add(y); 
		list.add(x); 
		return list;
	}
}

