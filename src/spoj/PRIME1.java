package spoj;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;

public class PRIME1 {
    static private ArrayList<Integer> primes = new ArrayList<>();

    private static void computePrimes() {
        for (int i = 2; i <= Math.sqrt(1000000000); i++) {
            if (isPrime(i)) primes.add(i);
        }
    }

    private static boolean isPrime(int n) {
        boolean isPrime = true;

        for (int j = 0; j < primes.size() && primes.get(j) <= Math.sqrt(n); j++) {
            if (n % primes.get(j) == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        computePrimes();
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            String[] s = in.readLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int n = Integer.parseInt(s[1]);

            for (int i = Math.max(m, 2); i <= n; i++) {
                if (isPrime(i)) System.out.println(i);
            }
            System.out.println();
        }
    }
}
