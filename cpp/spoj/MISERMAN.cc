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

    int n, m;
    cin >> n >> m;
    vector<vector<int>> buses(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> buses[i][j];
        }
    }

    int temp = INT32_MAX;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            temp = buses[i - 1][j];
            if (j > 0) {
                temp = min(temp, buses[i - 1][j - 1]);
            }
            if (j < m - 1) {
                temp = min(temp, buses[i - 1][j + 1]);
            }
            buses[i][j] += temp;
        }
    }

    int result = INT32_MAX;
    for (int j = 0; j < m; j++) {
        result = min(result, buses[n - 1][j]);
    }
    cout << result << "\n";
}
