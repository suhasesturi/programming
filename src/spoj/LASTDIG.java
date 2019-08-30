package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LASTDIG {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s = in.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            Map<Integer, Integer> map = new HashMap<>();
            ArrayList<Integer> list = new ArrayList<>();
            int lastDigit = 1;
            while (true) {
                lastDigit = (lastDigit * a) % 10;
                if (map.containsKey(lastDigit)) break;
                map.put(lastDigit, 1);
                list.add(lastDigit);
            }
            if (a == 0) System.out.println(0);
            else if (b == 0) System.out.println(1);
            else System.out.println(list.get((b - 1) % list.size()));
        }
    }
}
