#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, q;
    cin >> n >> q;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    int find, mid;
    for (int i = 0; i < q; i++) {
        cin >> find;
        int start = 0, end = n - 1;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] == find) {
                end = mid;
            } else if (arr[mid] > find) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        cout << ((end >= 0 && arr[end] == find) ? end : -1) << "\n";
    }

    return 0;
}
