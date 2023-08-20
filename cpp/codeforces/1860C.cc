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

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, count = 0, temp, last_value = -1,
               min_value = INT32_MAX;
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            if (last_value == -1) {
                if (min_value < temp) {
                    count++;
                    last_value = temp;
                } else {
                    min_value = temp;
                }
            } else if (last_value > temp && min_value < temp) {
                count++;
                last_value = temp;
            } else {
                min_value = min(min_value, temp);
            }
        }
        cout << count << "\n";
    }

    return 0;
}
