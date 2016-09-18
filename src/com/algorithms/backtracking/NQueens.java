package com.algorithms.backtracking;


/**
 * This class implements the nqueens problem. 
 * The problem statement is as follows
 * <p>
 *    Given a n * n board your task is to place n queens on the board so each of them are safe from each other.
 * </p>
 * <h1>
 *    Solution approach
 * </h1>
 * <p>
 *    We use backtracking as the solution approach. We start we row 0 and col 0. If it is safe to place the queen on that block we 
 *    place the queen on that block and move to the next row. If the current block is not safe to place the queen then we move to next column
 *    on same row. If we exhaust all columns in current row without finding safe block for the queen then we backtrack to previous row and move 
 *    the queen on previous row to next column and repeat the same process.
 * </p>
 * @author amit
 *
 */
public class NQueens {

	public static int SIZE = 4;
	
	/**
	 * Function prints the provided 2-dimensional on console.
	 * @param board two dimensional array that represents the chess board.
	 */
	public static void print(int board[][]) {
		System.out.println("--------");
		for(int i=0; i < SIZE; i++) {
			for(int j=0; j < SIZE; j++) {
				System.out.printf("%d ", board[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("--------");
	}
	
	/**
	 * Function checks to see if placing a queen on given row,col is safe to do.
	 * @param board 2 dimensional array that represents chess board.
	 * @param row row on which to place the queen
	 * @param col column on which to place the queen
	 * @return true if it is safe to place the queen on given location or else false.
	 */
	public static boolean isSafe(int[][] board, int row, int col) {
		for(int i=0; i < SIZE; i++) {
			for(int j=0; j < SIZE; j++) {
				if(board[i][j] == 1) {
					if(i == row) return false;
					if(j == col) return false;
					if(Math.abs(row-i) == Math.abs(col - j)) return false;
				}
			}
		}
		return true;
	}
	
	public static void nQueens(int board[][], int row) {
		
		if(row == SIZE) {
			print(board);
			return;
		}
		
		for(int col=0; col < SIZE; col++) {
			if(isSafe(board, row, col)) {
				board[row][col] = 1;
				nQueens(board, row+1);
				board[row][col] = 0;
			}
		}
	}
	
 	
	public static void main(String[] args) {
		int board[][] = new int[SIZE][SIZE];
		nQueens(board, 0);
	}
}
