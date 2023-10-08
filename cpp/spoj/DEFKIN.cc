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
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int w, h, n, x, y;
        cin >> w >> h >> n;
        vector<int> height(n + 2), width(n + 2);
        height[0] = 0;
        width[0] = 0;
        height[n + 1] = h + 1;
        width[n + 1] = w + 1;
        for (int i = 1; i <= n; i++) {
            cin >> width[i] >> height[i];
        }

        sort(height.begin(), height.end());
        sort(width.begin(), width.end());

        int max_width = 0, result = 0;
        for (int i = 1; i <= n + 1; i++) {
            max_width = max(max_width, width[i] - width[i - 1] - 1);
        }
        for (int i = 1; i <= n + 1; i++) {
            result = max(result, max_width * (height[i] - height[i - 1] - 1));
        }
        cout << result << "\n";
    }
    return 0;
}
