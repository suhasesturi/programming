#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

void swap(int a, int b, vector<int>& arr) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }

        int index = -1;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            cout << "-1\n";
            continue;
        }

        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                swap(i, index, arr);
                break;
            }
        }
        for (int i = index + 1, j = n - 1; i < j; i++, j--) {
            swap(i, j, arr);
        }
        for (int i = 0; i < n; i++) {
            cout << arr[i];
        }
        cout << "\n";
    }
    return 0;
}
