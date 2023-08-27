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
        int n, m, d, temp;
        cin >> n >> m >> d;
        int count = 0;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            while (temp > d) {
                count++;
                temp -= d;
            }
        }
        cout << (count >= m ? "YES" : "NO") << "\n";
    }
    return 0;
}
