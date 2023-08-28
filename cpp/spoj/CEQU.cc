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

int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int a, b, c;
        cin >> a >> b >> c;
        cout << "Case " << t << ": ";
        if (c % gcd(a, b) == 0) {
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }
    return 0;
}
