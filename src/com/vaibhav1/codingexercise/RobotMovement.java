/**
 * 
 */
package com.vaibhav1.codingexercise;

/**
 * @author vshukla
 *
 */
public class RobotMovement {
	
	
	public static String getBlockPositions(String command){
		
		int [][]stash = new int[15][10];
		
		
		int row = -1;
		int col = -1;
		for(char c:command.toCharArray()){
			if(c == 'P'){
				col=0;
				row=0;
			} else if(c == 'M'){
				if(col!=-1){
					col++;
				}
			} else if(c=='L'){
				
				if(col>=0 && col<10 && stash[row][col]<15 ){
					stash[row++][col]+=1;
				}
				
				if(row>=15){
					row = 0;
					col = 0;
				} else {
					col=-1;
					row=-1;
				}
				
				
			}
		}
		
		StringBuilder sb = new StringBuilder("");
		
		for(int i=0;i<10;i++){
			
			String output = "";
			if(stash[0][i]==10){
				output="A";
			}
			else if(stash[0][i]==11){
				output="B";
			}
			else if(stash[0][i]==12){
				output="C";
			}
			else if(stash[0][i]==13){
				output="D";
			}
			else if(stash[0][i]==14){
				output="E";
			}
			else if(stash[0][i]==15){
				output="F";
			}
			else {
				output = stash[0][i]+"";
			}
			sb.append(output);
		}
		
		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String out = getBlockPositions("PLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLPLML");
		System.out.println(out);

	}

}
