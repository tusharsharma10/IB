package arrays;

import java.util.ArrayList;

public class MaxAbsoluteDifference {

	/**
	 * O(m*n) solution
	 * 
	 * @param A
	 * @return
	 */
	public static int maxArr(ArrayList<Integer> A) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.size(); i++) {

			for (int j = i + 1; j < A.size(); j++) {

				int f = Math.abs(A.get(i) - A.get(j)) + Math.abs(i - j);
				if (f > max)
					max = f;
			}
		}

		return max;
	}

	/**
	 * O(n) solution
	 * 
	 * @param A
	 * @return
	 */
	public static int maxArr2(ArrayList<Integer> A) {
		int max1 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int max2 = Integer.MIN_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int i = 0; i < A.size(); i++) {

			// Updating max and min variables
			// as described in algorithm.
			max1 = Math.max(max1, A.get(i) + i);
			min1 = Math.min(min1, A.get(i) + i);
			max2 = Math.max(max2, A.get(i) - i);
			min2 = Math.min(min2, A.get(i) - i);
		}

		// Calculating maximum absolute difference.
		return Math.max(max1 - min1, max2 - min2);
	}

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(-1);
		System.out.println(maxArr2(a));

	}

}
