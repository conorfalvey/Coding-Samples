/* File:	SelectioneSort.java
 * Purpose:	Sort an integer array using Selection Sort
 * 
 * Input:	a:	Unsorted Integer Array
 * Output:	a:	Sorted Integer Array
 * 
 * Notes:	O(n^2) worst time
 */
public class SelectionSort implements SortingAlgorithm{

	@Override
	/* Function:	sort
	 * Purpose:		sort an array and call swap to sort with selection sort
	 * Input args:	int[] a:	unsorted array
	 * Output args:	int[] a:	sorted array
	 */
	public void sort(int[] a) {	 
		int outer = 0;
		while (outer < a.length - 1) {
            int min = outer;
            int inner = outer + 1;
            while (inner < a.length) {
                if (a[inner] < a[min]) {
                	min = inner;
                }
                inner++;
            }
            
            swap(a, min, outer);
            outer++;
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
