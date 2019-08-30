package interviewbit;

import java.util.ArrayList;

public class JustifiedText {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("lib/test");
        arr.add("it");
        arr.add("now");
        new JustifiedText().fullJustify(arr, 7);
    }

    public ArrayList<String> fullJustify(ArrayList<String> A, int B) {
        ArrayList<String> result = new ArrayList<>();
        if (A.isEmpty()) return result;
        boolean flag = false;
        for (String a : A) {
            if (!a.isEmpty()) {
                flag = true;
                break;
            }
        }
        if (!flag) return result;

        int length = 0;
        int previous = 0;
        for (int i = 0; i < A.size(); i++) {
            length += A.get(i).length();
            if (length > B) {
                length = A.get(i).length() + 1;

                int sumLength = 0;
                int emptyStrings = 0;
                for (int j = previous; j < i; j++) {
                    sumLength += A.get(j).length();
                    if (A.get(j).isEmpty()) emptyStrings++;
                }
                StringBuilder builder = new StringBuilder();
                int words = i - previous - 1 - emptyStrings;
                int remaining = words == 0 ? 0 : (B - sumLength) % words;

                for (int j = previous; j < i; j++) {
                    builder.append(A.get(j));
                    if (words == 0) {
                        for (int k = B; k > sumLength; k--) builder.append(' ');
                    } else {
                        for (int k = 1; k <= (B - sumLength) / words; k++) builder.append(' ');
                        if (remaining > 0) {
                            builder.append(' ');
                            remaining--;
                        }
                    }
                }

                result.add(builder.toString().substring(0, B));
                previous = i;
            } else {
                if (!A.get(i).isEmpty())
                    length++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int j = previous; j < A.size(); j++) {
            builder.append(A.get(j)).append(' ');
        }
        for (int i = builder.length() + 1; i <= B; i++) {
            builder.append(' ');
        }
        result.add(builder.toString().substring(0, B));
        return result;
    }
}
