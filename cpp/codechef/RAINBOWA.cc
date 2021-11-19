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
        int arr[n];
        for (int i = 0; i < n; ++i) {
            cin >> arr[i];
        }
        bool flag = true;
        int i, j;
        for (i = 0, j = n - 1; i < j; ++i, --j) {
            if (arr[i] != arr[j]) {
                flag = false;
                break;
            }

            if (arr[i] != arr[i + 1] && arr[i] != arr[i + 1] - 1) {
                flag = false;
                break;
            }
        }
        if (arr[i] != 7 || arr[0] != 1) {
            flag = false;
        }
        cout << (flag ? "yes" : "no") << "\n";
    }
    return 0;
}
