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

    int n;
    while (true) {
        cin >> n;
        if (n == 0) break;
        if (n == 1) {
            cout << "0\n";
            continue;
        }
        cout << ceil(log2(n)) - 1 << "\n";
    }

    return 0;
}
