#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
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
        int n, last;
        cin >> n;
        string temp;
        getline(cin, temp);
        vector<string> arr(n);

        for (int i = 0; i < n; i++) {
            getline(cin, arr[i]);
            arr[i] = arr[i].substr(0, 31);
        }

        sort(arr.begin(), arr.end());
        last = 0;
        int count = 1, index = 0;
        vector<int> dup_count;
        for (int i = 0; i < n; i++) {
            if (arr[i].compare(arr[last]) == 0) {
                count++;
            } else {
                arr[index] = arr[last];
                dup_count.push_back(i - last);
                count = 1;
                last = i;
                index++;
            }
        }
        arr[index] = arr[last];
        dup_count.push_back(n - last);

        for (int i = 0; i <= index; i++) {
            cout << arr[i] << " " << dup_count[i] << "\n";
        }
        cout << "\n";
    }
    return 0;
}
