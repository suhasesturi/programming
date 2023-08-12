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

    int g, b, n, m;
    while (true) {
        cin >> g >> b;
        if (g == -1 && b == -1) break;
        n = max(g, b);
        m = min(g, b);
        cout << ceil((double) n / (m + 1)) << "\n";
    }
}
