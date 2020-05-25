package interviewbit.Strings;

import java.util.ArrayList;

public class JustifiedText {
	public ArrayList<String> fullJustify(ArrayList<String> list, int L) {
		ArrayList<String> result = new ArrayList<>();
		int currentLength = 0;
		int previousIndex = 0;

		for (int i = 0; i < list.size(); i++) {
			currentLength += list.get(i).length();
			if (currentLength > L) {
				int lengthSum = 0;
				for (int j = previousIndex; j < i; j++) {
					lengthSum += list.get(j).length();
				}

				int spaces = i - previousIndex - 1;
				int extraSpaces = spaces == 0 ? 0 : (L - lengthSum) % spaces;
				StringBuilder builder = new StringBuilder();
				for (int j = previousIndex; j < i; j++) {
					builder.append(list.get(j));
					if (spaces == 0) {
						for (int k = lengthSum + 1; k <= L; k++) {
							builder.append(' ');
						}
					} else {
						for (int k = 1; k <= (L - lengthSum) / spaces; k++) {
							builder.append(' ');
						}
						if (extraSpaces > 0) {
							builder.append(' ');
							extraSpaces--;
						}
					}
				}

				result.add(builder.substring(0, L));
				previousIndex = i;
				currentLength = list.get(i).length() + 1;
			} else {
				if (!list.get(i).isEmpty()) {
					currentLength++;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		for (int i = previousIndex; i < list.size(); i++) {
			builder.append(list.get(i)).append(' ');
		}
		if (builder.length() > 0) {
			for (int i = builder.length() + 1; i <= L; i++) {
				builder.append(' ');
			}
			result.add(builder.substring(0, L));
		}

		return result;
	}
}
