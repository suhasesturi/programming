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

    unsigned long long n;
    cin >> n;
    set<unsigned long long> visited;
    visited.insert(n);
    while (n > 1) {
        if (n % 2 == 0) {
            n /= 2;
        } else {
            n = 3 * n + 3;
        }
        if (visited.count(n) == 0) {
            visited.insert(n);
        } else {
            break;
        }
    }
    cout << (n <= 1 ? "TAK" : "NIE");
}
