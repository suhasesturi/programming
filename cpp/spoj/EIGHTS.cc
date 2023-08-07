#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    long long k;
    cin >> t;
    while (t-- > 0) {
        cin >> k;
        cout << (192 + 250 * (k - 1)) << "\n";
    }
    return 0;
}
