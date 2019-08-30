package spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TOANDFRO {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int col = Integer.parseInt(in.readLine());
            if (col == 0) break;
            String cypher = in.readLine();
            for (int i = 0; i < col; i++) {
                int diff = 2 * i + 1;
                int index = i;
                while (index < cypher.length()) {
                    System.out.print(cypher.charAt(index));
                    diff = 2 * col - diff;
                    index = index + diff;
                }
            }
            System.out.println();
        }
    }
}
