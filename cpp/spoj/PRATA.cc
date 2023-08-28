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

struct Time {
    int val, coeff, actual_time;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        priority_queue<Time, vector<Time>, function<bool(Time, Time)>> pq(
            [](const Time& a, const Time& b) {
                return a.actual_time > b.actual_time;
            });
        int required, n, temp;
        cin >> required >> n;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            pq.push({temp, 1, temp});
        }
        Time current, inner;
        while (required > 0) {
            current = pq.top();
            while (!pq.empty()) {
                inner = pq.top();
                if (inner.actual_time > current.actual_time) {
                    break;
                }
                required--;
                pq.pop();
                pq.push({inner.val, inner.coeff + 1,
                         inner.actual_time + (inner.val * (inner.coeff + 1))});
            }
        }
        cout << current.actual_time << "\n";
    }
    return 0;
}
