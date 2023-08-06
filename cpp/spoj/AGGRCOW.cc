#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n, c;
        cin >> n >> c;
        vector<int> stalls(n);
        for (int i = 0; i < n; i++) {
            cin >> stalls[i];
        }
        sort(stalls.begin(), stalls.end());
        int smallest = 0, largest = 1e9;
        while (smallest < largest) {
            int maxMinDist = (smallest + largest) / 2 + 1;
            int cows = 1, last = 0;
            for (int i = 1; i < n && cows < c; i++) {
                if ((stalls[i] - stalls[last]) >= maxMinDist) {
                    last = i;
                    cows++;
                }
            }
            if (cows >= c) {
                smallest = maxMinDist;
            } else {
                largest = maxMinDist - 1;
            }
        }
        cout << smallest << "\n";
    }
    return 0;
}
