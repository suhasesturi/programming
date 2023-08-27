#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int mod = 1000000007;

void multiply(vector<vector<long long>>& F, vector<vector<long long>>& temp) {
    int x = ((F[0][0] * temp[0][0]) % mod + (F[0][1] * temp[1][0]) % mod) % mod;
    int y = ((F[0][0] * temp[0][1]) % mod + (F[0][1] * temp[1][1]) % mod) % mod;
    int z = ((F[1][0] * temp[0][0]) % mod + (F[1][1] * temp[1][0]) % mod) % mod;
    int w = ((F[1][0] * temp[0][1]) % mod + (F[1][1] * temp[1][1]) % mod) % mod;

    F[0][0] = x;
    F[0][1] = y;
    F[1][0] = z;
    F[1][1] = w;
}

void power(vector<vector<long long>>& F, int n) {
    if (n <= 1) return;
    vector<vector<long long>> temp = {{1, 1}, {1, 0}};
    while (n > 0) {
        if (n % 2 == 1) {
            multiply(F, temp);
        }
        multiply(temp, temp);
        n /= 2;
    }
}

long long fib(int n) {
    vector<vector<long long>> F = {{1, 1}, {1, 0}};
    if (n < 2) return n;
    power(F, n - 1);
    return F[0][1];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int from, to;
        cin >> from >> to;
        // sum of values till x = f(x + 2) - f(2)
        int till_to = fib(to + 2);
        int till_from = fib(from + 1);
        cout << (till_to - till_from + mod) % mod << "\n";
    }
    return 0;
}
