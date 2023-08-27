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

    int t;
    cin >> t;
    while (t-- > 0) {
        int a, b;
        cin >> a >> b;
        int divisor = gcd(a, b);
        int count = 0;
        for (int i = 1; i * i <= divisor; i++) {
            if (divisor % i == 0) {
                count += 2;
                if (divisor == i * i) count--;
            }
        }
        cout << count << "\n";
    }
    return 0;
}
