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

    int limit, n;
    int dp[101][501];
    int arr[100][2];
    while (true) {
        cin >> limit >> n;
        if (limit == 0 && n == 0) break;

        for (int i = 0; i < n; i++) {
            cin >> arr[i][0] >> arr[i][1];
        }

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= limit; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (w - arr[i - 1][0] >= 0) {
                    dp[i][w] =
                        max(dp[i - 1][w],
                            arr[i - 1][1] + dp[i - 1][w - arr[i - 1][0]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        int i;
        for (i = limit - 1; i >= 0; i--) {
            if (dp[n][i] != dp[n][limit]) {
                break;
            }
        }
        cout << i + 1 << " " << dp[n][limit] << "\n";
    }

    return 0;
}
