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
        int n;
        cin >> n;
        if (n == 0) {
            cout << "0\n";
            continue;
        }
        vector<pair<int, int>> activities(n, {0, 0});
        for (int i = 0; i < n; i++) {
            cin >> activities[i].first >> activities[i].second;
        }
        sort(activities.begin(), activities.end(),
             [](const pair<int, int>& a, const pair<int, int>& b) {
                 return a.second < b.second;
             });

        int count = 1, last = 0;
        for (int i = 1; i < n; i++) {
            if (activities[i].first >= activities[last].second) {
                count++;
                last = i;
            }
        }
        cout << count << "\n";
    }
}
