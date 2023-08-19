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

vector<vector<long long>> dp;

long long calc(vector<int>& arr, int start, int end) {
    long long age = arr.size() - (end - start);
    if (start == end) return arr[start] * age;
    if (dp[start][end] != -1) {
        return dp[start][end];
    }
    dp[start][end] = max(arr[start] * age + calc(arr, start + 1, end),
                         arr[end] * age + calc(arr, start, end - 1));
    return dp[start][end];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    dp.resize(n, vector<long long>(n, -1));

    cout << calc(arr, 0, n - 1) << "\n";

    return 0;
}
