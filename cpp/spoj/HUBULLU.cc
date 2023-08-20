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
        int n, op;
        cin >> n >> op;
        if (op == 0) {
            cout << "Airborne wins.\n";
        } else {
            cout << "Pagfloyd wins.\n";
        }
    }
    return 0;
}
