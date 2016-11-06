
/* Problem 8.11
 * Introduction to Java Programming, 10th Ed.
 * by Y Daniel Liang
 * 
 * (Game: nine heads and tails) Nine coins are placed in a 
 * 3-by-3 matrix with some face up and some face down. You 
 * can represent the state of the coins using a 3-by-3 matrix 
 * with values 0 (heads) and 1 (tails). Here are 
 * some examples:
 *  
 * 0 0 0   1 0 1   1 1 0   1 0 1   1 0 0   
 * 0 1 0   0 0 1   1 0 0   1 1 0   1 1 1 
 * 0 0 0   1 0 0   0 0 1   1 0 0   1 1 0 
 * 
 * Each state can also be represented using a binary number. 
 * For example, the preceding matrices correspond to the 
 * numbers 000010000 101001100 110100001 101110100 100111110 
 * There are a total of 512 possibilities, so you can use 
 * decimal numbers 0, 1, 2, 3, . . . , and 511 to represent 
 * all states of the matrix. Write a program that prompts the 
 * user to enter a number between 0 and 511 and displays the 
 * corresponding matrix with the characters H and T.
 */

/*
 * I made extensive use of the following websites:
 * https://www.tutorialspoint.com/java/java_basic_operators.htm
 * http://l3d.cs.colorado.edu/courses/CSCI1200-96/binary.html
 * http://docs.oracle.com/javase/tutorial/java/data/buffers.html
 * http://stackoverflow.com/questions/14784630/converting-decimal-to-
 * 		binary-java
 */
package src;

import java.util.Scanner;

public class Problem_8_11_2 {
	public static void main(String[] args) {
		int[][] matrix = new int[3][3];
		// initialize a new scanner
		Scanner input = new Scanner(System.in);
		// ask for user input
		System.out.print("Enter a number between 0 and 511: ");
		int matrixChoice = input.nextInt();
		// convert number to string representation of binary
		String binary = decimalToBinary(matrixChoice);
		int binaryIndex = 0; // binary string index
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// conditional operator
				int coinSide = (binary.charAt(binaryIndex++) == '0') 
						? 0 : 1;
				matrix[i][j] = coinSide;
			}
		}
		// Replace binary characters with H and/or T
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				// conditional operator
				char charMatrix = (matrix[i][j] == 0) ? 'H' : 'T';
				System.out.print(charMatrix + " ");
			}
			System.out.println("");
		}
	}
	// Custom method for converting numbers to binary and 
	// placing in a string
	public static String decimalToBinary(int number) {
		// use stringbuilder so leading 0's can be added if needed
		StringBuilder newString = new StringBuilder();
		// convert from decimal to binary string
		if (number != 0) {
			newString.append(Integer.toBinaryString(number));
		}
		// add leading zeros to bring total string length to 9
		while (newString.length() < 9) {
			newString.insert(0, "0");
		}
		// return as string
		return newString.toString();
	}
}
