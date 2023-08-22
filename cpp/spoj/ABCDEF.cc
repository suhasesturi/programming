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

    int n, temp;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    vector<int> first;
    map<int, int> second;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                first.push_back(arr[i] * arr[j] + arr[k]);
                if (arr[k] != 0) {
                    temp = (arr[i] + arr[j]) * arr[k];
                    if (second.count(temp) == 0) {
                        second[temp] = 1;
                    } else {
                        second[temp]++;
                    }
                }
            }
        }
    }

    long long count = 0;
    for (int i = 0; i < first.size(); i++) {
        count += second.count(first[i]) == 0 ? 0 : second[first[i]];
    }
    cout << count << "\n";
    return 0;
}
