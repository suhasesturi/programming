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

    int a, d;
    while (true) {
        cin >> a >> d;
        if (a == 0) break;
        vector<int> attackers(a), defenders(d);
        for (int i = 0; i < a; i++) {
            cin >> attackers[i];
        }
        for (int i = 0; i < d; i++) {
            cin >> defenders[i];
        }
        sort(attackers.begin(), attackers.end());
        sort(defenders.begin(), defenders.end());

        if (attackers[0] < defenders[1]) {
            cout << "Y\n";
        } else {
            cout << "N\n";
        }
    }

    return 0;
}
