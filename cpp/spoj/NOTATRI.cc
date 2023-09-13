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

    int n;
    while (true) {
        cin >> n;
        if (n == 0) break;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        sort(arr.begin(), arr.end());
        long long result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1, k = i + 2; j < n; j++) {
                while (k < n && ((arr[i] + arr[j]) >= arr[k])) {
                    k++;
                }
                result += n - k;
            }
        }
        cout << result << "\n";
    }

    return 0;
}
