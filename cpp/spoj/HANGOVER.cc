#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <stack>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    float c;
    while (true) {
        cin >> c;
        if (c == 0) break;
        float sum = 0;
        int i;
        for (i = 2; sum <= c; i++) {
            sum += 1.0 / i;
            // cout << sum << "\n";
        }
        // cout << c << " " << sum << " " << i << " card(s)\n";
        cout << (i - 2) << " card(s)\n";
    }

    return 0;
}
