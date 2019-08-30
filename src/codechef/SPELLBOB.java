package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SPELLBOB {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String top = in.readLine().toLowerCase();
            String bottom = in.readLine().toLowerCase();

            int countB = 0;
            int countO = 0;
            for (int i = 0; i < 3; i++) {
                if (top.charAt(i) == 'b' || bottom.charAt(i) == 'b') countB++;
                if (top.charAt(i) == 'o' || bottom.charAt(i) == 'o') countO++;
            }

            boolean flag = false;

            if (countB < 2 || countO == 0) flag = false;
            else if (countB == 3 || countO == 3) flag = true;
            else if (countO == 1) {
                for (int i = 0; i < 3; i++) {
                    if ((top.charAt(i) == 'b' || bottom.charAt(i) == 'b') &&
                            (top.charAt(i) == 'o' || bottom.charAt(i) == 'o')) {
                        flag = false;
                        break;
                    } else {
                        flag = true;
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    if (top.charAt(i) == 'b' || bottom.charAt(i) == 'b') countB--;
                    if (top.charAt(i) == 'o' || bottom.charAt(i) == 'o') countO--;
                    if (countB != countO) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }

            System.out.println(flag ? "yes" : "no");
        }
    }
}
