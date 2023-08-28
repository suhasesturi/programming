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

vector<int> lucky;

void populate_lucky() {
    for (int i = 2; lucky.size() < 1000; i++) {
        int count = 0, current = i;
        for (int j = 2; j * j <= current; j++) {
            if (current % j == 0) {
                count++;
                while (current % j == 0) {
                    current /= j;
                }
            }
        }
        if (current > 1) {
            count++;
        }
        if (count >= 3) {
            lucky.push_back(i);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    
    populate_lucky();
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        cout << lucky[n - 1] << "\n";
    }
    return 0;
}
