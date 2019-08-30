package interviewbit.Hashing;

public class WindowString {
    public String minWindow(String text, String pattern) {
        int[] hashPattern = new int[256];
        int[] hashText = new int[256];

        int start = 0, startIndex = -1, minLength = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < pattern.length(); i++) hashPattern[pattern.charAt(i)]++;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            hashText[ch]++;

            if (hashPattern[ch] != 0 && hashText[ch] <= hashPattern[ch]) count++;

            if (count == pattern.length()) {
                while (hashPattern[text.charAt(start)] == 0 ||
                        hashPattern[text.charAt(start)] < hashText[text.charAt(start)]) {
                    if (hashPattern[text.charAt(start)] < hashText[text.charAt(start)])
                        hashText[text.charAt(start)]--;
                    start++;
                }

                int tempLength = i - start + 1;
                if (tempLength < minLength) {
                    minLength = tempLength;
                    startIndex = start;
                }
            }
        }

        return startIndex == -1 ? "" : text.substring(startIndex, startIndex + minLength);
    }
}
