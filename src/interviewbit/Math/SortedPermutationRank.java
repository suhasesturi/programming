package interviewbit.Math;

public class SortedPermutationRank {
	private final Integer MOD = 1000003;

	public static void main(String[] args) {
		System.out.println(new SortedPermutationRank().findRank("view"));
	}

	public int findRank(String str) {
		long result = 1;
		int[] factorial = new int[str.length() + 1];
		factorial[0] = 1;
		for (int i = 1; i < factorial.length; i++) {
			factorial[i] = (int) (((long) factorial[i - 1] * i) % MOD);
		}
		for (int i = 0; i < str.length(); i++) {
			int lower = lowerCount(str, i);
			result = (result + ((long) lower * factorial[str.length() - i - 1]) % MOD) % MOD;
		}

		return (int) result;
	}

	private int lowerCount(String str, int i) {
		int count = 0;
		for (int j = i + 1; j < str.length(); j++) {
			if (str.charAt(j) < str.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
