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
        long long n;
        cin >> n;
        long long ans = (n * (n + 1)) % 1000007;
        ans = (ans + (n * (n - 1) / 2) % 1000007) % 1000007;
        cout << ans << "\n";
    }
    return 0;
}
