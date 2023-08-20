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

    int t;
    cin >> t;
    while (t-- > 0) {
        int m, k, a, b;
        cin >> m >> k >> a >> b;
        int result = 0;
        m = m - min(b, m / k) * k;
        if (m <= a) {
            cout << "0\n";
        } else {
            if (a > (k - 1)) {
                m = m - (a - (k - 1));
                a = (k - 1);
            }
            cout <<  (m / k + max(0, m % k - a)) << "\n";
        }
    }

    return 0;
}
