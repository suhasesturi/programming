#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        string old[n];
        bool found[n];
        for (int i = 0; i < n; ++i) {
            cin >> old[i];
            found[i] = false;
        }
        while (k--) {
            int l;
            cin >> l;
            string temp;
            while (l--) {
                cin >> temp;
                for (int i = 0; i < n; ++i) {
                    if (temp == old[i]) {
                        found[i] = true;
                    }
                }
            }
        }

        string output;
        for (int i = 0; i < n; ++i) {
            output = found[i] ? "YES" : "NO";
            cout << (i == n - 1 ? output : output + " ");
        }
        cout << "\n";
    }

    return 0;
}
