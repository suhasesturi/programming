package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class HMAPPY1 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = in.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int q = Integer.parseInt(temp[1]);
        int k = Integer.parseInt(temp[2]);
        ArrayList<Range> list = new ArrayList<>();

        temp = in.readLine().split(" ");

        Range current = new Range();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].equals("1")) {
                if (current.count == 0) current.start = i;
                current.end = i;
                current.count++;
            } else {
                if (current.count != 0) list.add(current);
                current = new Range();
                current.count = 0;
            }
        }
        if (current.count != 0) list.add(current);

        if (!list.isEmpty() &&
                list.get(list.size() - 1).end == n - 1 &&
                list.get(0).start == 0 &&
                list.get(0).end != n - 1) {
            Range first = list.get(0);
            Range last = list.get(list.size() - 1);
            first.start = last.start;
            first.count += last.count;

            list.remove(list.size() - 1);
        }
        list.sort(Comparator.comparingInt(o -> -o.count));

        String s = in.readLine();
        int moves = 0;
        for (int i = 0; i < q; i++) {
            if (s.charAt(i) == '!') moves++;
            else {
                int result = 0;
                boolean flag = false;
                for (Range r : list) {
                    int count = r.count;
                    if (count == n) {
                        flag = true;
                    } else {
                        int start = (r.start + moves) % n;
                        int end = (r.end + moves) % n;
                        if (start > end) {
                            count = Math.max(n - start, end + 1);
                            flag = true;
                        }
                    }
                    result = Math.max(result, count);
                    if (!flag) break;
                }
                System.out.println(Math.min(result, k));
            }
        }
    }
}

class Range {
    int count;
    int start;
    int end;
}