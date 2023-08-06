#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int a, b;
        cin >> a >> b;
        if (a == 0) {
            cout << 0 << "\n";
            continue;
        }
        int result = 1;
        while (b > 0) {
            if (b % 2 != 0) {
                result = (result * a) % 10;
            }
            a = (a * a) % 10;
            b /= 2;
        }
        cout << result << "\n";
    }
    return 0;
}
