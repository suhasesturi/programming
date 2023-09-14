#include <math.h>
#include <stdint.h>

#include <algorithm>
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

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, u, l, r, q;
        long long v;
        cin >> n >> u;
        vector<long long> arr(n + 1, 0);
        while (u-- > 0) {
            cin >> l >> r >> v;
            arr[l] += v;
            arr[r + 1] -= v;
        }

        for (int i = 1; i <= n; i++) {
            arr[i] += arr[i - 1];
        }

        cin >> q;
        while (q-- > 0) {
            cin >> l;
            cout << arr[l] << "\n";
        }
    }

    return 0;
}
