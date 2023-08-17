#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    while (true) {
        cin >> n;
        if (n == -1) break;
        long long start = 0, end = 100000;
        long long sum = 0;
        bool flag = false;
        while (start <= end) {
            long long mid = (start + end) / 2;
            sum = 1 + 6 * (mid * (mid + 1) / 2);
            if (sum == n) {
                flag = true;
                break;
            }
            if (sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        cout << (flag ? "Y" : "N") << "\n";
    }

    return 0;
}
