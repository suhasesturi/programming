#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <vector>

using namespace std;

long long split_inversions(vector<int>& arr, int p, int q, int r) {
    int n1 = q - p + 1;
    int n2 = r - q;
    vector<int> left(n1 + 1);
    vector<int> right(n2 + 1);
    for (int i = 0; i < n1; i++) {
        left[i] = arr[p + i];
    }
    for (int i = 0; i < n2; i++) {
        right[i] = arr[q + i + 1];
    }
    left[n1] = max(left[n1 - 1], right[n2 - 1]);
    right[n2] = left[n1];

    long long count = 0;
    for (int i = 0, j = 0, k = p; k <= r; k++) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
            if (i != n1) count += n1 - i;
        }
    }
    return count;
}

long long inversions(vector<int>& arr, int p, int r) {
    if (p >= r) return 0;
    int q = (p + r) / 2;
    long long x = inversions(arr, p, q);
    long long y = inversions(arr, q + 1, r);
    long long z = split_inversions(arr, p, q, r);
    return x + y + z;
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
        cout << inversions(arr, 0, n - 1) << "\n";
    }
    return 0;
}

