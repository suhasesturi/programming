#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t, x, y;
    cin >> t;
    while (t-- > 0) {
        cin >> x >> y;
        if (x == y) {
            cout << ((x % 2 == 0) ? (2 * x) : (2 * x - 1)) << "\n";
        } else if (x - y == 2 && x >= 2) {
            cout << (x % 2 == 0 ? x + y : x + y - 1) << "\n";
        } else {
            cout << "No Number\n";
        }
    }
    return 0;
}
