#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int maxXor(int arr[], int n) {
    stack<int> st;
    int result = 0;
    for (int i = 0; i < n; i++) {
        while (!st.empty() && st.top() < arr[i]) {
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
    int arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int result = maxXor(arr, n);
    for (int i = 0, j = n - 1; i < j; i++, j--) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    result = max(result, maxXor(arr, n));
    cout << result << "\n";
    return 0;
}
