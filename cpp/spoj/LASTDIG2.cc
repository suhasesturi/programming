#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        long long a, b;
        string s;
        cin >> s >> b;
        a = (s[s.length() - 1] - '0');
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
