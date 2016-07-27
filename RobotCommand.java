/**
 * 
 */
package com.expedia.code;

/**
 * @author vshukla
 *
 */
public class RobotCommand {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String command = "PLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPL";

		String response = compute(command);

		System.out.println(response);

	}

	private static String compute(String command) {
		char[][] blocks = new char[15][10];

		int rowIndex = 14;
		int colIndex = 0;

		for (char c : command.toCharArray()) {

			if (c == 'P') {
				colIndex = 0;
			}

			else if (c == 'M') {
				colIndex++;
			}

			else if (c == 'L') {
				
				if(colIndex<10 && blocks[14][colIndex] == '$'){
					while(rowIndex >0 && blocks[rowIndex][colIndex] == '$'){
						System.out.print(rowIndex+", ");
						
						rowIndex--;
					}
					System.out.println();
				}
				
				if (rowIndex >= 0 && colIndex < 10) {
						blocks[rowIndex][colIndex] = '$';
				}
					
			}
			rowIndex = 14;
			
		}
		
		
		return countBlocksPositions(blocks);
	}

	/**
	 * @param blocks
	 * @param blockPosition
	 * @return
	 */
	private static String countBlocksPositions(char[][] blocks) {
		StringBuilder blockPosition = new StringBuilder("");
		
		
		for (int i = 0; i < 15; i++) {
			;

			for (int j = 0; j < 10; j++) {
				
				System.out.print(blocks[i][j]+", ");
				
			}
			System.out.println();
		}
		
		for (int i = 0; i < 10; i++) {
			int count = 0;

			for (int j = 0; j < 15; j++) {
				
				
				
				if (blocks[j][i] == '$') {
					count++;
				}
			}
			if (count == 10) {
				blockPosition.append('A');
			} else if (count == 11) {
				blockPosition.append('B');
			} else if (count == 12) {
				blockPosition.append('C');
			} else if (count == 13) {
				blockPosition.append('D');
			} else if (count == 14) {
				blockPosition.append('E');
			} else if (count == 15) {
				blockPosition.append('F');
			} else {
				blockPosition.append(count);
			}
		}
		
		return blockPosition.toString();
	}

}
