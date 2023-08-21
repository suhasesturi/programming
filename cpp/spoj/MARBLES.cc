#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        long long n, k;
        cin >> n >> k;
        long long result = 1;
        for (int i = n - k + 1, j = 1; i <= n - 1; i++, j++) {
            if (i % j == 0) {
                result = result * (i / j);
            } else if (result % j == 0) {
                result = (result / j) * i;
            } else {
                result = result * i / j;
            }
        }
        cout << result << "\n";
    }
    return 0;
}
