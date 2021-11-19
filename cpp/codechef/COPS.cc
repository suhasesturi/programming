#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int m, x, y, current;
        cin >> m >> x >> y;
        int houses[100] = {0};
        while (m--) {
            cin >> current;
            current -= 1;
            for (int i = max(0, current - x * y); i <= min(current + x * y, 99);
                 ++i) {
                houses[i] = 1;
            }
        }
        int count = 0;
        for (int i = 0; i < 100; ++i) {
            if (houses[i] == 0) {
                count++;
            }
        }
        cout << count << "\n";
    }

    return 0;
}
