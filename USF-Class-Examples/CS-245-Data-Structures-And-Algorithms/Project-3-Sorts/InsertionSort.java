/* File:	InsertionSort.java
 * Purpose:	Sort an integer array using Insertion Sort
 * 
 * Input:	a:	Unsorted Integer Array
 * Output:	a:	Sorted Integer Array
 * 
 * Notes:	O(n^2) worst time
 */
public class InsertionSort implements SortingAlgorithm {

	@Override
	/* Function:	sort
	 * Purpose:		sort array and call swap to sort with insertion method
	 * Input args:	int[] a:	unsorted array
	 * Output args:	int[] a:	sorted array
	 */
	public void sort(int[] a) {
		int outer = 1;
		while (outer < a.length) {
            int temp = a[outer];
            int inner = outer-1;
 
            while (inner >= 0 && a[inner] > temp) {
                a[inner + 1] = a[inner];
                inner = inner-1;
            }
            
            a[inner + 1] = temp;
			outer++;
        }
	} /*	sort	*/
}
