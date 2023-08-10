#include <math.h>

#include <algorithm>
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

    int t;
    cin >> t;
    while (t-- > 0) {
        unsigned long long n;
        cin >> n;
        cout << (n * (n + 2) * (2 * n + 1)) / 8 << "\n";
    }
    return 0;
}
