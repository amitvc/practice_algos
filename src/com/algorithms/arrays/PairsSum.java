package com.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author amit
 *
 */
public class PairsSum {

	public static void printPairs(int a[], int targetSum) {
		Arrays.sort(a);
		int lhs = 0;
		int rhs = a.length-1;
		while(lhs != rhs) {
			if(a[rhs] + a[lhs] == targetSum) {
				System.out.println("{"+ a[rhs]+","+ a[lhs]+ "}");
				rhs--;
			} else if(a[rhs] + a[lhs] < targetSum) {
				lhs++;
			} else {
				rhs--;
			}
		}
		
	}
	
	public static void printPairsHashMap(int a[], int targetSum) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i < a.length; i++) {
			if(map.containsKey(a[i])) {
				System.out.println("{"+ a[i] +","+ (targetSum - a[i]) +"}");
			} else {
				map.put(targetSum-a[i], a[i]);
			}
		}
	
	}
	
	
	public static void main(String[] args) {
		
		int a[] = {-3,1,2,4,3,5,7,2,1,0,11,2,3,0,6};
		//printPairs(a, 3);
		printPairsHashMap(a, 3);
	}

}
