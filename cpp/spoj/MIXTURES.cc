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

    int n;
    while (cin >> n) {
        vector<vector<vector<long long>>> dp(
            n, vector<vector<long long>>(n, vector<long long>(2, INT32_MAX)));
        for (int i = 0; i < n; i++) {
            cin >> dp[i][i][1];
            dp[i][i][0] = 0;
        }

        int current = 0;
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < n - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i; k < j; k++) {
                    current = dp[i][k][0] + dp[k + 1][j][0] +
                              dp[i][k][1] * dp[k + 1][j][1];
                    if (dp[i][j][0] > current) {
                        dp[i][j][0] = current;
                        dp[i][j][1] = (dp[i][k][1] + dp[k + 1][j][1]) % 100;
                    }
                }
            }
        }
        cout << dp[0][n - 1][0] << "\n";
    }

    return 0;
}
