package ch05.sec09;

import java.util.Arrays;

public class ArrayCopyByForExample {

	public static void main(String[] args) {
		int[] oldIntArray = { 1, 2, 3 };

		int[] newIntArray = new int[5];

		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i] = oldIntArray[i];

		}

		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ", ");
		}
		
		int[] arr2 = new int[10];
		// arraycopy
		System.arraycopy(oldIntArray, 1, arr2, 0, 2);
		System.out.println(Arrays.toString(arr2));
		// Arrays.copyOf()
		int[] arr3 = Arrays.copyOf(oldIntArray, 10);
		System.out.println(Arrays.toString(arr3));
	}

}
