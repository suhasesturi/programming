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

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        int a = 0, level = n;
        while (a < level) {
            long long mid = (a + level) / 2;
            if ((mid * (mid + 1) / 2) >= n) {
                level = mid;
            } else {
                a = mid + 1;
            }
        }
        int position = n - ((level - 1) * level / 2);
        if (level % 2 == 0) {
            cout << "TERM " << n << " IS " << position << "/"
                 << (level - position + 1) << "\n";
        } else {
            cout << "TERM " << n << " IS " << (level - position + 1) << "/"
                 << position << "\n";
        }
    }
    return 0;
}
