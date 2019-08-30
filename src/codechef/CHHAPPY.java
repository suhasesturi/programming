package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class CHHAPPY {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] temp = in.readLine().split(" ");
            int[][] arr = new int[n + 1][2];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                arr[i][1] = i;
                arr[i][0] = Integer.parseInt(temp[i - 1]);
                map.put(arr[i][0], i);
            }

            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

            int current = 1;
            boolean flag = false;
            for (int i = 2; i <= n && !flag; i++) {
                if (arr[i][0] == arr[current][0]) {
                    if (map.containsKey(arr[i][1]) && map.containsKey(arr[current][1])) flag = true;
                    else if (map.containsKey(arr[i][1])) current = i;
                } else {
                    current = i;
                }
            }

            if (flag) System.out.println("Truly Happy");
            else System.out.println("Poor Chef");
        }
    }
}
