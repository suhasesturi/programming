#include <math.h>
#include <stdint.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

// can also be solved using segment tree. See solution in spoj submissions
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k, temp;
    cin >> n;
    vector<int> arr(n);
    multiset<int> pq;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cin >> k;
    for (int i = 0; i < k; i++) {
        pq.insert(arr[i]);
    }
    for (int i = k, j = 0; i < n; i++, j++) {
        cout << *pq.rbegin() << " ";
        pq.erase(arr[j]);
        pq.insert(arr[i]);
    }
    cout << *pq.rbegin() << " ";

    return 0;
}
