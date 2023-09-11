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
        int a, b, c;
        cin >> a >> b >> c;
        map<pair<int, int>, int> visited;
        visited.insert({{0, 0}, 0});

        deque<pair<int, int>> dq;
        dq.push_back({0, 0});
        bool flag = false;
        while (!dq.empty()) {
            pair<int, int> current = dq.front();
            dq.pop_front();

            auto entry = visited.find(current);
            if (current.first == c || current.second == c) {
                cout << entry->second << "\n";
                flag = true;
                break;
            }

            int can = min(current.first, b - current.second);
            int can2 = min(a - current.first, current.second);
            vector<pair<int, int>> next_options = {
                {0, current.second},
                {current.first, 0},
                {a, current.second},
                {current.first, b},
                {current.first - can, current.second + can},
                {current.first + can2, current.second - can2}};

            for (pair<int, int> next : next_options) {
                if (visited.count(next) == 0) {
                    visited.insert({next, entry->second + 1});
                    dq.push_back(next);
                }
            }
        }
        if (!flag) {
            cout << "-1\n";
        }
    }
    return 0;
}
