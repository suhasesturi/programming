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
        int n, m, temp;
        cin >> n;
        vector<int> first(n);
        for (int i = 0; i < n; i++) {
            cin >> first[i];
        }
        cin >> m;
        vector<int> second(m);
        for (int i = 0; i < m; i++) {
            cin >> second[i];
        }
        sort(first.begin(), first.end());
        sort(second.begin(), second.end());

        int result = INT32_MAX;
        int i, j;
        for (int i = 0, j = 0; i < n && j < m;) {
            result = min(result, abs(first[i] - second[j]));
            if (first[i] < second[j]) {
                i++;
            } else {
                j++;
            }
        }
        cout << result << "\n";
    }
    return 0;
}
