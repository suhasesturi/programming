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
        int m, n;
        cin >> m >> n;
        m--;
        n--;
        vector<int> horizontal(m), vertical(n);
        for (int i = 0; i < m; i++) {
            cin >> horizontal[i];
        }
        for (int i = 0; i < n; i++) {
            cin >> vertical[i];
        }
        sort(horizontal.rbegin(), horizontal.rend());
        sort(vertical.rbegin(), vertical.rend());

        int column = 1, row = 1, i, j;
        long long result = 0;
        for (i = 0, j = 0; i < m && j < n;) {
            if (horizontal[i] < vertical[j]) {
                result += row * vertical[j++];
                column++;
            } else {
                result += column * horizontal[i++];
                row++;
            }
        }
        while (i < m) {
            result += column * horizontal[i++];
        }
        while (j < n) {
            result += row * vertical[j++];
        }
        cout << result << "\n";
    }
    return 0;
}
