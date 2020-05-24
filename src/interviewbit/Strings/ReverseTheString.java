package interviewbit.Strings;

public class ReverseTheString {
    public String solve(String A) {
        String[] words = A.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                builder.append(words[i]).append(" ");
            }
        }

        return builder.length() == 0 ? "" : builder.substring(0, builder.length() - 1);
    }
}
