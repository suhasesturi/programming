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
        string s;
        cin >> s;
        long count = 0;
        for (char ch : s) {
            if (ch == '1') {
                count++;
            }
        }
        cout << (count * (count + 1)) / 2 << "\n";
    }

    return 0;
}
