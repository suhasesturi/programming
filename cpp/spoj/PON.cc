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
#include <unordered_map>
#include <vector>

using namespace std;

uint64_t power(uint64_t a, uint64_t b, uint64_t mod) {
    uint64_t result = 1;
    while (b != 0) {
        if (b & 1) {
            result = ((__uint128_t)result * a) % mod;
        }
        a = ((__uint128_t)a * a) % mod;
        b >>= 1;
    }
    return result;
}

bool check_composite(uint64_t n, uint64_t a, uint64_t d, int s) {
    uint64_t x = power(a, d, n);
    if (x == 1 || x == (n - 1)) {
        return false;
    }
    for (int r = 1; r < s; r++) {
        x = ((__uint128_t)x * x) % n;
        if (x == n - 1)
            return false;
    }
    return true;
}

bool miller_rabin_primality(uint64_t n, int iter = 10) {
    if (n < 4)
        return n == 2 || n == 3;
    uint64_t d = n - 1;
    int s = 0;
    while ((d & 1) == 0) {
        d >>= 1;
        s++;
    }
    for (int i = 0; i < iter; i++) {
        int a = 2 + rand() % (n - 3);
        if (check_composite(n, a, d, s))
            return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        uint64_t n;
        cin >> n;
        cout << (miller_rabin_primality(n, 10) ? "YES" : "NO") << "\n";
    }
    return 0;
}
