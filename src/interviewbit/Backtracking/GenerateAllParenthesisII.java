package interviewbit.Backtracking;

import java.util.ArrayList;

public class GenerateAllParenthesisII {
	public static void main(String[] args) {
		System.out.println(new GenerateAllParenthesisII().generateParenthesis(3));
	}

	public ArrayList<String> generateParenthesis(int A) {
		ArrayList<String> result = new ArrayList<>();
		generate(A, result, new StringBuilder(), 1, 0);
		return result;
	}

	private void generate(int a, ArrayList<String> result, StringBuilder builder, int index, int open) {
		if (index == a + 1) {
			if (builder.length() == 2 * a) {
				result.add(builder.toString());
			}
			return;
		}
		builder.append('(');
		open++;

		for (int i = 0; i <= open; i++) {
			for (int j = 0; j < i; j++) {
				builder.append(')');
			}
			generate(a, result, builder, index + 1, open - i);
			if (i > 0) {
				builder.delete(builder.length() - i, builder.length());
			}
		}
		builder.deleteCharAt(builder.length() - 1);
	}
}
