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

        long long result = 0;
        int temp;
        for (int i = 0, j = 0; i < n && j < n;) {
            while (i < n && arr[i] <= 0) {
                i++;
            }
            while (i < n && arr[j] >= 0) {
                j++;
            }
            temp = min(abs(arr[j]), abs(arr[i]));
            arr[j] += temp;
            arr[i] -= temp;
            result += temp * abs(i - j);
        }

        cout << result << "\n";
    }

    return 0;
}
