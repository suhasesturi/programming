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
        string s;
        cin >> s;
        bool flag = true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                flag = false;
                break;
            }
        }
        cout << (flag ? "YES" : "NO") << "\n";
    }
    return 0;
}
