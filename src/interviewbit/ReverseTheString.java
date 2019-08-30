package interviewbit;

public class ReverseTheString {
    public String reverseWords(String str) {
        String[] words = str.split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                builder.append(words[i]).append(' ');
            }
        }
        return builder.toString().trim();
    }
}
