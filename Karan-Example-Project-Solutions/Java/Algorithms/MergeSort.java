import java.util.Random;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[100];

		array = random.ints(100, 0, 1000).toArray();
		System.out.println("Before sort: " + Arrays.toString(array));
		sort(array);
		System.out.println("After sort: " + Arrays.toString(array));
	}

	private static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int a[], int min, int max) {
		if (min < max) {
			int mid = (min + max) / 2;
			sort(a, min, mid);
			sort(a, mid + 1, max);

			mergeSubarray(a, min, mid, max);
		}
	}

	private static void mergeSubarray(int[] a, int min, int mid, int max) {
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

		for (; tempOneIndex <= mid - min; tempOneIndex++) {
			a[index] = tempOne[tempOneIndex];
			index++;
		}

		for (; tempTwoIndex <= max - mid - 1; tempTwoIndex++) {
			a[index] = tempTwo[tempTwoIndex];
			index++;
		}
	}
}
