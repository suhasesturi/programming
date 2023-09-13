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

    int a, b, m;
    cin >> a >> b >> m;
    vector<bool> dp(1e6 + 1);
    dp[0] = false;
    for (int i = 1; i <= 1e6; i++) {
        if (!dp[i - 1] || (i - a >= 0 && !dp[i - a]) ||
            (i - b >= 0 && !dp[i - b])) {
            dp[i] = true;
        } else {
            dp[i] = false;
        }
    }
    int n;
    while (m--) {
        cin >> n;
        cout << (dp[n] ? 'A' : 'B');
    }
    cout << "\n";

    return 0;
}
