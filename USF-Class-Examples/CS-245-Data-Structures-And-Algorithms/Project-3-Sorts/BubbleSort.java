/* File:	BubbleSort.java
 * Purpose:	Sort an integer array using Bubble Sort
 * 
 * Input:	a:	Unsorted Integer Array
 * Output:	a:	Sorted Integer Array
 * 
 * Notes:	O(n^2) worst time
 */
public class BubbleSort implements SortingAlgorithm {

	@Override
	/* Function:	sort
	 * Purpose:		sort though array and call swap to sort array with bubble sort
	 * Input args:	int[] a:	unsorted array
	 * Output args:	int[] a:	sorted array
	 */
	public void sort(int[] a) {
		for (int outer = 0; outer < a.length - 1; outer++) {
			for (int inner = 0; inner < a.length - outer - 1; inner++) {
				if (a[inner] > a[inner + 1]) {
					swap(a, inner, inner + 1);
				}
			}
		}	
	} /*	sort	*/
	
	/* Function:	swap
	 * Purpose:		swap two positions in an array
	 * Input args:	int[] a:		unsorted array
	 * 				int indexOne:	position one to swap
	 * 				int indexTwo:	position two to swap
	 * Output args:	int[] a:		array with two swapped values
	 */
	public void swap(int[] a, int indexOne, int indexTwo) {
		int temp = a[indexOne];
		a[indexOne] = a[indexTwo];
		a[indexTwo] = temp;
	} /*	swap	*/
}
