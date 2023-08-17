#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
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

    int t, temp;
    cin >> t;
    set<int> unique;
    while (t-- > 0) {
        cin >> temp;
        if (unique.count(temp) == 0) {
            unique.insert(temp);
        } else {
            unique.erase(temp);
        }
    }
    cout << *unique.begin() << "\n";
    return 0;
}
