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
        string s;
        cin >> s;
        if (s.compare("()") == 0) {
            cout << "NO\n";
            continue;
        }

        cout << "YES\n";
        string result(2 * s.length(), '0');
        for (int i = 0; i < s.length() * 2; i++) {
            result[i] = i % 2 == 0 ? '(' : ')';
        }

        if (result.find(s) != -1) {
            for (int i = 0; i < s.length() * 2; i++) {
                result[i] = i < s.length() ? '(' : ')';
            }
        }

        cout << result << "\n";
    }

    return 0;
}
