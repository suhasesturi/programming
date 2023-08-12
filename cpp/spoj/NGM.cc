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

    int n;
    cin >> n;
    int last = n % 10;
    if (last == 0) {
        cout << 2 << "\n";
    } else {
        cout << "1\n" << last << "\n";
    }
    return 0;
}
