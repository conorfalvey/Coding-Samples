/* File:		BinaryIterativeSearh.java
 * Purpose:		Find value in given array using a binary iterative search
 * 
 * Input:		int[] arr: 	array to be searched
 * 				int target: value to be searched for
 * Output:		position of target value
 * 
 * Run Args: 	<fill size>:		size of array to fill
 * 				<search number>:	number of searches to perform
 * 				<type>:				type of search to perform
 * 
 * Notes: 		searchName() is used by Practice2Test to determine search type
 */
package edu.usfca.cs.cs245;

public class BinaryIterativeSearch implements Practice2Search {

	@Override
	//returns type of search
	public String searchName() {
		return "binary-iterative";
	}

	@Override
	//search method with while loop
	public int search(int[] arr, int target) {
		//set search variables
		int begin = 0;
		int ending = arr.length - 1;
		
		//while loop, while array size exists:
		while (begin < ending) {
			//calculate midpoint
			int midPoint = (begin+ending)/2;
			
			//test cases
			if (arr[midPoint] > target) {
				ending = midPoint-1;
			}
			
			if (arr[midPoint] < target) {
				begin = midPoint+1;
			}
			
			//test for equivalence
			if (arr[midPoint] == target) {
				return midPoint;
			}
		}
		//not found case
		return -1;
	}

}
