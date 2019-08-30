package interviewbit.Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PointsOnAStraightLine {
    public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
        HashMap<Pair, Integer> slopes = new HashMap<>();
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
            int overlaps = 0, vertical = 0, currentMax = 0;
            for (int j = i + 1; j < a.size(); j++) {
                if (a.get(i).equals(a.get(j)) && b.get(i).equals(b.get(j))) {
                    overlaps++;
                } else if (a.get(i).equals(a.get(j))) {
                    vertical++;
                } else {
                    int yDiff = b.get(j) - b.get(i);
                    int xDiff = a.get(j) - a.get(i);
                    int gcd = gcd(xDiff, yDiff);

                    xDiff /= gcd;
                    yDiff /= gcd;

                    if (xDiff < 0 && yDiff < 0) {
                        xDiff = -xDiff;
                        yDiff = -yDiff;
                    } else if (xDiff < 0 || yDiff < 0) {
                        if (xDiff >= 0) {
                            xDiff = -xDiff;
                            yDiff = -yDiff;
                        }
                    }

                    Pair pair = new Pair(xDiff, yDiff);
                    if (slopes.containsKey(pair)) slopes.put(pair, slopes.get(pair) + 1);
                    else slopes.put(new Pair(xDiff, yDiff), 1);

                    currentMax = Math.max(currentMax, slopes.get(pair));
                }

                currentMax = Math.max(currentMax, vertical);
            }

            result = Math.max(result, currentMax + overlaps + 1);
            slopes.clear();
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static class Pair {
        int x, y;

        Pair(int a, int b) {
            x = a;
            y = b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object obj) {
            Pair o = (Pair) obj;
            return this.x == o.x && this.y == o.y;
        }
    }
}
