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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        long long n;
        cin >> n;
        bool flag = true;
        for (long long i = 2; i * i <= n + 1; i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if ((i - 3) % 4 == 0) {
                if (count % 2 != 0) {
                    flag = false;
                    break;
                }
            }
        }
        if (n > 1 && (n - 3) % 4 == 0) {
            flag = false;
        }

        cout << (flag ? "Yes" : "No") << "\n";
    }
    return 0;
}
