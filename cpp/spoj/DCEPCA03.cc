#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // https://cp-algorithms.com/algebra/phi-function.html#properties
    int n = 10000;
    vector<long long> coprimes(n + 1);
    for (int i = 0; i <= n; i++) {
        coprimes[i] = i;
    }

    for (int i = 2; i <= n; i++) {
        if (coprimes[i] == i) {
            for (int j = i; j <= n; j += i) {
                coprimes[j] -= coprimes[j] / i;
            }
        }
    }
    for (int i = 1; i <= n; i++) {
        coprimes[i] += coprimes[i - 1];
    }

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        cout << coprimes[n] * coprimes[n] << "\n";
    }
    return 0;
}
