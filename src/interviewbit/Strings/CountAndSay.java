package interviewbit.Strings;

public class CountAndSay {
	public String countAndSay(int A) {
		String start = "1";
		A--;
		StringBuilder next = new StringBuilder();
		while (A-- > 0) {
			for (int i = 0; i < start.length(); ) {
				char ch = start.charAt(i);
				int count = 0;
				while (i < start.length() && start.charAt(i) == ch) {
					i++;
					count++;
				}
				next.append(count).append(ch);
			}
			start = next.toString();
			next = new StringBuilder();
		}
		return start;
	}
}
