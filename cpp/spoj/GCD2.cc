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

int modulo(string& s, int x) {
    int current = 0;
    for (int i = 0; i < s.length(); i++) {
        current = current * 10 + s[i] - '0';
        if (current >= x) {
            current = current % x;
        }
    }
    return current;
}

int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int a;
        string b;
        cin >> a >> b;
        if (a == 0) {
            cout << b << "\n";
            continue;
        }
        cout << gcd(a, modulo(b, a)) << "\n";
    }
    return 0;
}
