/* File:	MergeSort.java
 * Purpose:	Sort an integer array using Merge Sort
 * 
 * Input:	a:	Unsorted Integer Array
 * Output:	a:	Sorted Integer Array
 * 
 * Notes:	O(n logn) worst time
 */
public class MergeSort implements SortingAlgorithm {

	@Override
	/* Function:	sort
	 * Purpose:		call recursive sort method with initial values
	 * Input args:	int[] a:	unsorted array
	 * Output args:	int[] a:	sorted array
	 */
	public void sort(int[] a) {
		sort(a, 0, a.length - 1);
	} /*	sort	*/

	/* Function:	sort
	 * Purpose:		overloaded recursive sort method with divide and conquer recursive logic that divides array into subarrays
	 * Input args:	int[] a:	unsorted array
	 * 				int min:	minimum bound for subarray
	 * 				int max:	maximum bound for subarray
	 * Output args:	int[] a:	sorted array/subarray
	 */
	public void sort(int a[], int min, int max) {
		if (min < max) {
			int mid = (min + max) / 2;
			sort(a, min, mid);
			sort(a, mid + 1, max);

			mergeSubarray(a, min, mid, max);
		}
	} /*	sort	*/

	/* Function:	merge
	 * Purpose:		creates two subarrays from bounds, merges the arrays together in order, and combines the arrays
	 * Input args:	int[] a:	unsorted array
	 * 				int min:	minimum bound for subarray
	 * 				int mid:	split point of the two subarrays
	 * 				int max:	maximum bound for subarray
	 * Output args:	int[] a:	sorted subarray
	 */
	public void mergeSubarray(int[] a, int min, int mid, int max) {
		int tempOne[] = new int[mid - min + 1];
		int tempTwo[] = new int[max - mid];

		for (int i = 0; i <= mid - min; ++i) {
			tempOne[i] = a[min + i];
		}

		for (int j = 0; j <= max - mid - 1; j++) {
			tempTwo[j] = a[mid + 1 + j];
		}

		int tempOneIndex = 0;
		int tempTwoIndex = 0;
		int index = min;
		while (tempOneIndex <= mid - min && tempTwoIndex <= max - mid - 1) {
			if (tempOne[tempOneIndex] < tempTwo[tempTwoIndex] + 1) {
				a[index] = tempOne[tempOneIndex];
				tempOneIndex++;
			} else {
				a[index] = tempTwo[tempTwoIndex];
				tempTwoIndex++;
			}
			index++;
		}

		//leaned this trick in CS 220 - Parallel Computing
		for (; tempOneIndex <= mid - min; tempOneIndex++) {
			a[index] = tempOne[tempOneIndex];
			index++;
		}

		for (; tempTwoIndex <= max - mid - 1; tempTwoIndex++) {
			a[index] = tempTwo[tempTwoIndex];
			index++;
		}
	} /*	merge	*/
}
