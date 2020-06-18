package interviewbit.Hashing;

public class WindowString {
	public static void main(String[] args) {
		System.out.println(new WindowString().minWindow("ADOBECODEBANC", "ABC"));
	}

	public String minWindow(String text, String pattern) {
		int[] hPattern = new int[256];
		int[] hText = new int[256];

		for (int i = 0; i < pattern.length(); i++) {
			hPattern[pattern.charAt(i)]++;
		}

		int length = Integer.MAX_VALUE, start = 0, count = 0, startIndex = -1;
		for (int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			hText[ch]++;

			if (hPattern[ch] != 0 && hText[ch] <= hPattern[ch]) count++;

			if (count == pattern.length()) {
				while (hPattern[text.charAt(start)] == 0 ||
						hPattern[text.charAt(start)] < hText[text.charAt(start)]) {
					if (hPattern[text.charAt(start)] < hText[text.charAt(start)]) {
						hText[text.charAt(start)]--;
					}
					start++;
				}

				int tempLength = i - start + 1;
				if (tempLength < length) {
					length = tempLength;
					startIndex = start;
				}
				count--;
				hText[text.charAt(start)]--;
				start++;
			}
		}

		return startIndex == -1 ? "" : text.substring(startIndex, startIndex + length);
	}
}
