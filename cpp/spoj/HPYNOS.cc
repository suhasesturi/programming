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

    int n, count = 0;
    cin >> n;
    set<int> sums;
    while (n != 1) {
        if (sums.count(n) == 0) {
            sums.insert(n);
        } else {
            break;
        }

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        n = sum;
        count++;
    }
    cout << (n == 1 ? count : -1) << "\n";
}
