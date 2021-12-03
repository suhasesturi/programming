#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;
int mod = 1000000007;

long long power(int a, int b) {
    long long result = 1;
    if (b == 0) return 1;
    result = power(a, b / 2);
    result = (result * result) % mod;
    if (b % 2 != 0) {
        result = (result * a) % mod;
    }
    return result;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << (power(2, ceil((n + 1.0) / 2)) +
                 power(2, floor((n + 1.0) / 2)) - 2) %
                    mod
             << "\n";
    }
    return 0;
}
