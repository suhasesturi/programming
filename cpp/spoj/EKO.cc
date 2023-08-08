#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n, m;
    cin >> n >> m;
    vector<int> heights(n);
    for (int i = 0; i < n; i++) {
        cin >> heights[i];
    }
    long long a = 0, b = 1000000000;
    while (a < b) {
        long long mid = (a + b) / 2 + 1;
        long long sum = 0;
        for (int i = 0; i < n && sum < m; i++) {
            sum += max((long long)0, heights[i] - mid);
        }
        if (sum >= m) {
            a = mid;
        } else {
            b = mid - 1;
        }
    }
    cout << a;

    return 0;
}
