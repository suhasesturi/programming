package interviewbit.Strings;

import java.util.ArrayList;

public class ValidIpAddresses {
	public static void main(String[] args) {
		System.out.println(new ValidIpAddresses().restoreIpAddresses("0100100"));
	}
	public ArrayList<String> restoreIpAddresses(String A) {
		ArrayList<String> result = new ArrayList<>();
		int n = A.length();
		if (n < 4 || n > 12) return result;

		String current = A;
		for (int i = 1; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					current = current.substring(0, k) + "." + current.substring(k);
					current = current.substring(0, j) + "." + current.substring(j);
					current = current.substring(0, i) + "." + current.substring(i);

					if (isValid(current)) {
						result.add(current);
					}
					current = A;
				}
			}
		}

		result.sort((a, b) -> {
			String[] first = a.split("\\.");
			String[] second = b.split("\\.");

			for (int i = 0; i < 4; i++) {
				if (!first[i].equals(second[i])) {
					return first[i].compareTo(second[i]);
				}
			}
			return 1;
		});

		return result;
	}

	private boolean isValid(String ip) {
		String[] parts = ip.split("\\.");
		for (String part : parts) {
			long l = Long.parseLong(part);
			if (part.length() > 3 || l > 255) return false;
			if (part.length() > 1 && l == 0) return false;
			if (part.length() > 1 && part.charAt(0) == '0') return false;
		}
		return true;
	}
}
