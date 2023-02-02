#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

long long power(int a, int b, int mod) {
    if (b == 0) return 1;
    long long result = power(a, b / 2, mod);
    result = (result * result) % mod;
    if (b % 2 == 1) {
        result = (result * a) % mod;
    }
    return result;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    vector<int> primes{2,  3,  5,  7,  11, 13, 17, 19, 23, 29, 31, 37, 41,
                       43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
    int n, current;
    cin >> n;
    vector<vector<int>> cf(n + 1, vector<int>(primes.size(), 0));
    for (int i = 1; i <= n; i++) {
        cin >> current;
        for (int j = 0; j < primes.size(); j++) {
            while (current % primes[j] == 0) {
                cf[i][j]++;
                current /= primes[j];
            }
            cf[i][j] += cf[i - 1][j];
        }
    }

    int t;
    cin >> t;
    while (t--) {
        int l, r, m;
        cin >> l >> r >> m;
        long long result = 1;
        for (int i = 0; i < primes.size(); i++) {
            result =
                (result * power(primes[i], cf[r][i] - cf[l - 1][i], m)) % m;
        }
        cout << result << "\n";
    }

    return 0;
}
