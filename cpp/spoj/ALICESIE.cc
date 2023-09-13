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

    int t, n;
    cin >> t;
    while (t-- > 0) {
        cin >> n;
        cout << ceil(n / 2.0) << "\n";
    }
    return 0;
}
