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

    int n, top;
    while (true) {
        cin >> n;
        if (n == 0) break;

        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        arr.push_back(0);

        stack<int> st;
        long long result = 0;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && arr[st.top()] >= arr[i]) {
                top = st.top();
                st.pop();

                result =
                    max(result, (long long)(st.empty() ? i : i - st.top() - 1) *
                                    arr[top]);
            }
            st.push(i);
        }
        cout << result << "\n";
    }

    return 0;
}
