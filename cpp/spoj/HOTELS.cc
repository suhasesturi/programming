#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    vector<long long> arr(n + 1);
    arr[0] = 0;
    long long maximum = 0, sum = 0;
    for (int i = 1, j = 1; i <= n; i++) {
        cin >> arr[i];
        sum += arr[i];
        while (sum > m && j <= i) {
            sum -= arr[j];
            j++;
        }
        maximum = max(maximum, sum) ;
    }
    cout << maximum << "\n";

    return 0;
}
