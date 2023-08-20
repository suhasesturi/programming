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
        int a, W, n;
        cin >> a >> W;
        W -= a;
        cin >> n;
        vector<pair<int, int>> values(n);
        for (int i = 0; i < n; i++) {
            cin >> values[i].first >> values[i].second;
        }

        vector<long long> dp(W + 1, INT64_MAX);
        dp[0] = 0;
        for (int w = 1; w <= W; w++) {
            for (int i = 0; i < n; i++) {
                if (w - values[i].second >= 0 &&
                    dp[w - values[i].second] != INT64_MAX) {
                    dp[w] =
                        min(dp[w], values[i].first + dp[w - values[i].second]);
                }
            }
        }
        if (dp[W] == INT64_MAX) {
            cout << "This is impossible.\n";
        } else {
            cout << "The minimum amount of money in the piggy-bank is " << dp[W] << ".\n";
        }
    }
    return 0;
}
