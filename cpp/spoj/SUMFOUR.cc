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
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> a(n), b(n), c(n), d(n);
    for (int i = 0; i < n; i++) {
        cin >> a[i] >> b[i] >> c[i] >> d[i];
    }
    vector<long long> first;
    vector<long long> second;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            first.push_back(a[i] + b[j]);
            second.push_back(c[i] + d[j]);
        }
    }
    sort(second.begin(), second.end());

    long long count = 0;
    for (int x : first) {
        auto bounds = equal_range(second.begin(), second.end(), -x);
        count += bounds.second - bounds.first;
    }
    cout << count << "\n";

    return 0;
}
