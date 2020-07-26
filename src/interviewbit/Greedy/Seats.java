package interviewbit.Greedy;

public class Seats {
	public int seats(String A) {
		int total = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x') total++;
		}
		int count = 0, weight = 0, result = 0;
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) == 'x') {
				count++;
				weight = count > (total / 2) ? total - count : count;
			} else {
				result = (result + weight) % 10000003;
			}
		}
		return result;
	}
}
