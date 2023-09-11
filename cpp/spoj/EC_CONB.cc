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

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        if (n % 2 == 1) {
            cout << n << "\n";
            continue;
        }
        string s = "";
        while (n > 0) {
            s += n % 2 == 0 ? '0' : '1';
            n /= 2;
        }

        reverse(s.begin(), s.end());
        long long result = 0, power_2 = 1;
        for (int i = 0; i < s.size(); i++) {
            result += power_2 * (s[i] - '0');
            power_2 *= 2;
        }
        cout << result << "\n";
    }
    return 0;
}
