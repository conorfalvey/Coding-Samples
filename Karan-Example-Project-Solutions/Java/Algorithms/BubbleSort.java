import java.util.Random;
import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[100];

		array = random.ints(100, 0, 1000).toArray();
		System.out.println("Before sort: " + Arrays.toString(array));
		sort(array);
		System.out.println("After sort: " + Arrays.toString(array));
	}

	private static void sort(int[] a) {
		for (int outer = 0; outer < a.length - 1; outer++) {
			for (int inner = 0; inner < a.length - outer - 1; inner++) {
				if (a[inner] > a[inner + 1]) {
					swap(a, inner, inner + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int indexOne, int indexTwo) {
		int temp = a[indexOne];
		a[indexOne] = a[indexTwo];
		a[indexTwo] = temp;
	}
}
