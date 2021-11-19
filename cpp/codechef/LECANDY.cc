#include <algorithm>
#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, c, temp;
        cin >> n >> c;
        for (int i = 0; i < n; ++i) {
            cin >> temp;
            c -= temp;
        }
        cout << (c >= 0 ? "Yes" : "No") << "\n";
    }

    return 0;
}
