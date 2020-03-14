package arrays;

import java.util.ArrayList;

public class MinStepsInfiniteGrid {
	public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

		int count = 0;
		int m1 = 0;
		int m2 = 0;

		for (int i = 0; i < A.size() - 1; i++) {

			m1 = (int) Math.abs(A.get(i) - A.get(i + 1));
			m2 = (int) Math.abs(B.get(i) - B.get(i + 1));

			count += Math.max(m1, m2);

		}

		return count;

	}

	public static void main(String[] args) {

	}

}
