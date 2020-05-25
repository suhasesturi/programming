package interviewbit.Strings;

import java.util.ArrayList;

public class PrettyJson {
	public static void main(String[] args) {
		ArrayList<String> strings = new PrettyJson().prettyJSON("{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}");
		for (int i = 0; i < strings.size(); i++) {
			System.out.println(strings.get(i));
		}
	}

	public ArrayList<String> prettyJSON(String A) {
		ArrayList<String> result = new ArrayList<>();
		int indents = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if (ch == '[' || ch == '{') {
				if (builder.length() > 0) {
					result.add(indentation(indents) + builder.toString());
					builder = new StringBuilder();
				}
				result.add(indentation(indents) + ch);
				indents++;
			} else if (ch == '}' || ch == ']') {
				if (builder.length() > 0) {
					result.add(indentation(indents) + builder.toString());
					builder = new StringBuilder();
				}
				indents--;
				if ((i + 1) < A.length() && A.charAt(i + 1) == ',') {
					result.add(indentation(indents) + ch + ',');
					i++;
				} else {
					result.add(indentation(indents) + ch);
				}
			} else if (ch == ',') {
				builder.append(ch);
				result.add(indentation(indents) + builder.toString());
				builder = new StringBuilder();
			} else {
				builder.append(ch);
			}
		}

		return result;
	}

	private String indentation(int n) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append('\t');
		}
		return builder.toString();
	}
}
