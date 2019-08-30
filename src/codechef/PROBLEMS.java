package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class PROBLEMS {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = in.readLine().split(" ");
        int p = Integer.parseInt(temp[0]);
        int s = Integer.parseInt(temp[1]);

        int[][] difficulties = new int[p][2];
        for (int i = 0; i < p; i++) {
            String[] scores = in.readLine().split(" ");
            String[] contestants = in.readLine().split(" ");

            Triplet[] problems = new Triplet[s];
            for (int j = 0; j < s; j++) {
                problems[j] = new Triplet(
                        Integer.parseInt(scores[j]),
                        Integer.parseInt(contestants[j]),
                        j
                );
            }

            Arrays.sort(problems, Comparator.comparingInt(a -> a.score));

            int n = 0;
            for (int j = 1; j < s; j++) {
                if (problems[j - 1].contestant > problems[j].contestant) n++;
            }

            difficulties[i][0] = n;
            difficulties[i][1] = i;
        }

        Arrays.sort(difficulties, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            else return a[0] - b[0];
        });

        for (int i = 0; i < p; i++) {
            System.out.println(difficulties[i][1] + 1);
        }
    }
}

class Triplet {
    int score, index, contestant;

    public Triplet(int score, int contestant, int index) {
        this.score = score;
        this.index = index;
        this.contestant = contestant;
    }
}