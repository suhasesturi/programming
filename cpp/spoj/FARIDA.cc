#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int n;
        cin >> n;
        if (n == 0) {
            cout << "Case " << t << ": 0\n";
            continue;
        }
        vector<long long> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
            if (i == 1) {
                arr[1] = max(arr[0], arr[1]);
            }
            if (i >= 2) {
                arr[i] = max(arr[i - 1], arr[i] + arr[i - 2]);
            }
        }
        cout << "Case " << t << ": " << arr[n - 1] << "\n";
    }
    return 0;
}
