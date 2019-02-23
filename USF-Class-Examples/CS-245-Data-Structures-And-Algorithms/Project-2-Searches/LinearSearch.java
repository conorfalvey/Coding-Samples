/* File:		LinearSearh.java
 * Purpose:		Find value in given array using a linear search
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

public class LinearSearch implements Practice2Search {

	@Override
	//returns type of search
	public String searchName() {		
		return "linear";
	}

	@Override
	//basic for loop through array to find target
	public int search(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==target) {
				return i;
			}
		}
		return -1;
	}

}
