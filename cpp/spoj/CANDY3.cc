#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        long long n, sum = 0, temp;
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            sum = (sum + temp) % n;

        }
        if (sum % n == 0) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }
    return 0;
}
