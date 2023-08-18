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
    priority_queue<pair<int, int>> pq;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    cin >> k;
    for (int i = 0; i < k; i++) {
        pq.push({arr[i], i});
    }
    cout << pq.top().first << " ";

    for (int i = k, j = 0; i < n; i++, j++) {
        pq.push({arr[i], i});
        while (pq.top().second <= j) {
            pq.pop();
        }
        cout << pq.top().first << " ";
    }

    return 0;
}
