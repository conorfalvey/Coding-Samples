/* File:		BinaryRecursiveSearh.java
 * Purpose:		Find value in given array using a binary recursive search
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

public class BinaryRecursiveSearch implements Practice2Search {

	@Override
	//returns type of search
	public String searchName() {
		return "binary-recursive";
	}

	@Override
	//called class, calls recursive searchHelper() method
	public int search(int[] arr, int target) {
		return searchHelper(arr, target, 0, arr.length-1);
	}
	
	//recursive helper method
	private int searchHelper(int[] arr, int target, int begin, int ending) {
		///base case
		if (begin >= ending) {
			return -1;
		}
		
		//sets midpoint
		int midPoint = (begin + ending)/2;
		
		//test cases
		if (arr[midPoint] > target) {
			return searchHelper(arr, target, begin, midPoint - 1);
		}
		
		if (arr[midPoint] < target) {
			return searchHelper(arr, target, midPoint + 1, ending);
		}
		
		//final return
		return midPoint;
	}

}
