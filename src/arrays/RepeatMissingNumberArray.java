package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatMissingNumberArray {
	public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
		ArrayList<Integer> ob = new ArrayList<Integer>();

		if (A.size() == 0)
			return ob;

		else {

			long sum1 = 0;
			long sum2 = 0;

			long sumSqr1 = 0;
			long sumSqr2 = 0;

			for (int i = 0; i < A.size(); i++) {

				sum1 += i + 1;
				sum2 += A.get(i);
				sumSqr1 += (long)Math.pow(i + 1, 2);
				sumSqr2 += (long)Math.pow(A.get(i), 2);
			}

			int diff = (int) Math.abs(sum2 - sum1);
			int diffSqr = (int) Math.abs(sumSqr2 - sumSqr1);

			for (int i = 1; i <= A.size() - diff; i++) {

				if (Math.abs(Math.pow(i, 2) - Math.pow(i + diff, 2)) == diffSqr) {

					ob.add(i);
					ob.add(i + diff);

				}

			}

			if (ob.size() == 2) {

				for (int i = 0; i < A.size(); i++) {

					int valA = A.get(i);
					int valOb = ob.get(0);

					if (valA == valOb)
						break;

					if (i == A.size() - 1 && ob.get(0) != A.get(i)) {

						// swap positions
						int temp = ob.get(0);
						ob.set(0, ob.get(1));
						ob.set(1, temp);

					}

				}
			}

			return ob;
		}
	}

	public static void main(String[] args) {

		int arr[] = {1111111};
		ArrayList<Integer> ob = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {

			ob.add(arr[i]);

		}

		ArrayList<Integer> ob2 = repeatedNumber(ob);

		System.out.println(ob2);

	}

}
