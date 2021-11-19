#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int val[n], smallest = INT32_MAX;
        for (int i = 0; i < n; ++i) {
            cin >> val[i];
            smallest = min(smallest, val[i]);
        }
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += val[i] - smallest;
        }
        cout << count << "\n";
    }

    return 0;
}
