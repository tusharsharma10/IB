package arrays;

import java.util.ArrayList;

public class Flip {

	public static ArrayList<Integer> flip(String s) {

		ArrayList<Integer> ans = new ArrayList<>();

		char arr[] = s.toCharArray();
		int maxCountOnes = countOnes(arr);

		char temp[] = new char[arr.length];

		for (int r = 0; r < arr.length; r++) {

			for (int l = 0; l <= r; l++) {
				temp = s.toCharArray();
				for (int i = l; i <= r; i++) {
					if (temp[i] == '0')
						temp[i] = '1';
					else if (temp[i] == '1')
						temp[i] = '0';

				}

				if (maxCountOnes < countOnes(temp)) {
					maxCountOnes = countOnes(temp);
					if (ans.size() == 2) {
						ans.set(0, l + 1);
						ans.set(1, r + 1);
					}

					else {
						ans.add(l + 1);
						ans.add(r + 1);
					}
				}
			}

		}

		return ans;
	}

	public static int countOnes(char arr[]) {

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == '1')
				count++;

		}
		return count;
	}

	/**
	 * Optimal solution
	 * 
	 * @param args
	 */

	public ArrayList<Integer> flip2(String A) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int start = 1;
		result.add(0);
		result.add(0);
		int count = -1;
		boolean all1 = true;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length(); i++) {
			if (count < 0) {
				count = 0;
				start = i + 1;
			}
			char c = A.charAt(i);
			if (c == '0') {
				count++;
				all1 = false;
			} else
				count--;

			if (count > max) {
				max = count;
				result.set(0, start);
				result.set(1, i + 1);
			}
		}
		if (all1)
			return new ArrayList<Integer>();
		return result;
	}

	public static void main(String[] args) {
		String s = "010";
		ArrayList<Integer> ans = flip(s);

		System.out.println(ans);
	}

}
