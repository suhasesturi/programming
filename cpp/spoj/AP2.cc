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
        long long third, lthird, sum;
        cin >> third >> lthird >> sum;
        long long n = (2 * sum) / (third + lthird);
        long long diff = (lthird - third) / (n - 5);
        long long first = third - 2 * diff;
        cout << n << "\n";
        while (n-- > 0) {
            cout << first << " ";
            first += diff;
        }
        cout << "\n";
    }
    return 0;
}
