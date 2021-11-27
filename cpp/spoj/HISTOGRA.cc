#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    while (n != 0) {
        int heights[n + 1];
        for (int i = 0; i < n; ++i) {
            cin >> heights[i];
        }
        heights[n] = -1;

        stack<int> st;
        long long result = 0;
        int i = 0;
        while (i <= n) {
            if (st.empty() || heights[st.top()] <= heights[i]) {
                st.push(i);
                i++;
            } else {
                int top = st.top();
                st.pop();
                result = max(result, (long long)heights[top] *
                                         (st.empty() ? i : i - st.top() - 1));
            }
        }
        cout << result << "\n";

        cin >> n;
    }

    return 0;
}
