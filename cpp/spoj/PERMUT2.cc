#include <math.h>
#include <stdint.h>

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

    while (true) {
        int n;
        cin >> n;
        if (n == 0) break;
        vector<int> arr(n + 1);
        for (int i = 1; i <= n; i++) {
            cin >> arr[i];
        }
        bool flag = true;
        for (int i = 1; i <= n; i++) {
            if (i != arr[arr[i]]) {
                flag = false;
                break;
            }
        }
        cout << (flag ? "ambiguous" : "not ambiguous") << "\n";
    }
    return 0;
}
