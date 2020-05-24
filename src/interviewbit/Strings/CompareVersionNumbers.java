package interviewbit.Strings;

public class CompareVersionNumbers {
	public static void main(String[] args) {
		System.out.println(new CompareVersionNumbers().compareVersion("01.0", "1"));
	}

	public int compareVersion(String A, String B) {
		String[] first = A.split("\\.");
		String[] second = B.split("\\.");

		int sizeA = arraySize(first);
		int sizeB = arraySize(second);

		for (int i = 0, j = 0; i < first.length && j < second.length; i++, j++) {
			String f = getString(first[i]);
			String s = getString(second[j]);
			if (f.length() > s.length()) return 1;
			if (f.length() < s.length()) return -1;
			if (!f.equals(s)) {
				return f.compareTo(s) < 0 ? -1 : 1;
			}
		}
		return Integer.compare(sizeA, sizeB);
	}

	private int arraySize(String[] first) {
		int n = first.length;
		for (int i = first.length - 1; i > 0; i--) {
			String current = getString(first[i]);
			if (current.equals("0")) {
				n--;
			} else {
				break;
			}
		}
		return n;
	}

	private String getString(String str) {
		int index = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '0') {
				index = i;
				break;
			}
		}
		return index >= str.length() ? "0" : str.substring(index);
	}
}
