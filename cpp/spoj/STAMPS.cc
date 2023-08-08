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

    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int required, n;
        cin >> required >> n;
        vector<int> stamps(n);
        for (int i = 0; i < n; i++) {
            cin >> stamps[i];
        }
        sort(stamps.rbegin(), stamps.rend());
        int min_frnds = 0;
        for (int i = 0; i < n && required > 0; i++) {
            required -= stamps[i];
            min_frnds++;
        }

        cout << "Scenario #" << t << ":\n";
        if (required <= 0) {
            cout << min_frnds << "\n\n";
        } else {
            cout << "impossible\n\n";
        }
    }

    return 0;
}
