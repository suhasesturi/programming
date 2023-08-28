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

int mod = 10000007;

long long power(long long n, long long k) {
    if (n == 0) return 0;
    long long result = 1;
    while (k > 0) {
        if (k % 2 == 1) {
            result = (result * n) % mod;
        }
        n = (n * n) % mod;
        k /= 2;
    }
    return result;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n, k;
    while (true) {
        cin >> n >> k;
        if (n == 0 && k == 0) break;
        long long result = 0;
        result = (2 * power(n - 1, k)) % mod;
        result = (result + (2 * power(n - 1, n - 1)) % mod) % mod;
        result = (result + power(n, k)) % mod;
        result = (result + power(n, n)) % mod;
        cout << result << "\n";
    }
}
