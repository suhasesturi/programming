#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, temp;
        cin >> n >> k;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            cin >> temp;
            if ((temp + k) % 7 == 0) {
                count++;
            }
        }
        cout << count << "\n";
    }
    return 0;
}
