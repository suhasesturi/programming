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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, k;
        cin >> n >> k;
        vector<int> price(k);
        for (int i = 0; i < k; i++) {
            cin >> price[i];
        }
        vector<int> dp(k + 1, INT32_MAX);
        dp[0] = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (price[j] >= 0 && dp[i - j - 1] != INT32_MAX) {
                    dp[i] = min(dp[i], dp[i - j - 1] + price[j]);
                }
            }
        }

        cout << (dp[k] == INT32_MAX ? -1 : dp[k]) << "\n";
    }
    return 0;
}
