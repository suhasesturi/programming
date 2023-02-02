#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int t;
    cin >> t;
    while (t--) {
        int b;
        cin >> b;
        if (b % 2 != 0) {
            b--;
        }
        int result = 0;
        while (b > 0) {
            result += (b - 2) / 2;
            b -= 2;
        }
        cout << result << "\n";
    }

    return 0;
}
