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

// can also be solved using greedy, choose water if health > 5 and armour is >
// 10, else choose fire
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    vector<vector<int>> dp(1005, vector<int>(1030, 0));
    for (int h = 0; h <= 1000; h++) {
        for (int a = 0; a <= 1020; a++) {
            if (h == 0 || a == 0) dp[h][a] = 0;
            if (h > 5 && a > 10) {
                dp[h][a] = max(dp[h][a], 2 + dp[h - 2][a - 8]);
            }
            if (h > 20) {
                dp[h][a] = max(dp[h][a], 2 + dp[h - 17][a + 7]);
            }
        }
    }

    int t;
    cin >> t;
    while (t-- > 0) {
        int health, armour;
        cin >> health >> armour;
        cout << 1 + dp[health + 3][armour + 2] << "\n";
    }
    return 0;
}
