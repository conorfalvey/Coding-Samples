/* File:	QuickSort.java
 * Purpose:	Sort an integer array using Quick Sort
 * 
 * Input:	a:	Unsorted Integer Array
 * Output:	a:	Sorted Integer Array
 * 
 * Notes:	O(n^2) worst time
 */
public class QuickSort implements SortingAlgorithm {

	@Override
	/* Function:	sort
	 * Purpose:		call recursive sort method with initial values
	 * Input args:	int[] a:	unsorted array
	 * Output args:	int[] a:	sorted array
	 */
	public void sort(int[] a) {
		sort(a, 0, a.length-1);
	}
	
	/* Function:	sort
	 * Purpose:		overloads sort function recursively and partitions and sorts array with a divide and conquer method
	 * Input args:	int[] a:	unsorted array
	 * 				int min:	minimum value for given section of array
	 * 				int max:	maximum value for given section of array
	 * Output args:	int[] a:	sorted array after all recursion is done
	 */
	public void sort(int[] a, int min, int max) {
        if (min <= max - 1) {
            int part = partition(a, min, max) + 1;
            sort(a, min, part - 1);
            sort(a, part + 1, max);
        }
    } /*	sort	*/
	
	/* Function:	partition
	 * Purpose:		divides array at a point and sorts both sides of the array
	 * Input args:	int[] a:	unsorted array
	 * 				int min:	minimum index for particular partition
	 * 				int max:	maximum value for particular partition
	 * Output args:	int small:	integer to use in recursive partition call to divide further
	 */
	public int partition(int[] a, int min, int max) {
        int mid = a[max]; 
        int small = (min - 1);
        int outer = min;
        while (outer < max) {
            if (a[outer] < mid + 1) {
            	small++;
                swap(a, small, outer);
            }
            outer++;
        }
        swap(a, small + 1, max);
        return small;
    } /*	partition	*/
	
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

