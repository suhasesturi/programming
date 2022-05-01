#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class DivisorInc {
   public:
    static constexpr int inf = 100010;
    int countOperations(int n, int m) {
        vector<int> dp(inf, inf);
        dp[n] = 0;

        for (int i = n; i <= m; i++) {
            if (dp[i] != inf) {
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        int k = i + j;
                        if (k <= m) {
                            dp[k] = min(dp[k], dp[i] + 1);
                        }

                        k = i + i / j;
                        if (k <= m) {
                            dp[k] = min(dp[k], dp[i] + 1);
                        }
                    }
                }
            }
        }

        return dp[m] >= inf ? -1 : dp[m];
    }
};
