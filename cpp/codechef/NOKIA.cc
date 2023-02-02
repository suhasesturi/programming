#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int max = n * (n + 1) / 2 + n;
        int min = 0;
        stack<int> st;
        st.push(n + 1);
        while (!st.empty()) {
            int current = st.top();
            st.pop();
            min += current;
            if (current / 2 > 1) {
                st.push(current / 2);
            }
            if (current - current / 2 > 1) {
                st.push(current - current / 2);
            }
        }
        if (m < min) {
            cout << -1 << "\n";
        } else if (m >= max) {
            cout << m - max << "\n";
        } else {
            cout << 0 << "\n";
        }
    }

    return 0;
}
