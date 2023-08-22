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
    map<string, int> sequence = {{"TTT", 0}, {"TTH", 1}, {"THT", 2},
                                 {"THH", 3}, {"HTT", 4}, {"HTH", 5},
                                 {"HHT", 6}, {"HHH", 7}};
    while (t-- > 0) {
        int n;
        cin >> n;
        string s;
        cin >> s;
        vector<int> result(8, 0);
        for (int i = 0; i < s.length() - 2; i++) {
            result[sequence[s.substr(i, 3)]]++;
        }
        cout << n << " ";
        for (int i = 0; i < result.size(); i++) {
            cout << result[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
