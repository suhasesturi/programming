#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, temp, m;
    cin >> n;
    int count = 0;
    set<int> s;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        if (s.count(temp) != 0) {
            count--;
        }
        s.insert(temp);
        cin >> m;
        for (int j = 0; j < m; j++) {
            cin >> temp;
            if (s.count(temp) == 0) {
                s.insert(temp);
                count++;
            }
        }
    }
    cout << count << "\n";

    return 0;
}
