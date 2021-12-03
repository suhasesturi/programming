#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int maxXor(vector<int> &arr) {
    int n = arr.size();
    stack<int> st;
    int result = 0;
    for (int i = 0; i < n; i++) {
        while (!st.empty() && st.top() < arr[i]) {
            result = max(result, st.top() ^ arr[i]);
            st.pop();
        }
        if (!st.empty()) {
            result = max(result, st.top() ^ arr[i]);
        }
        st.push(arr[i]);
    }

    return result;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cout << maxXor(arr) << "\n";
    return 0;
}
