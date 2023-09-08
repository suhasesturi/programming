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

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, temp;
        cin >> n;
        map<int, int> count;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            if (count.count(temp) == 0) {
                count[temp] = 1;
            } else {
                count[temp]++;
            }
        }
        bool flag = false;
        for (auto current : count) {
            if (current.second > n / 2) {
                cout << "YES " << current.first << "\n";
                flag = true;
                break;
            }
        }
        if (flag == false) {
            cout << "NO\n";
        }
    }
    return 0;
}
