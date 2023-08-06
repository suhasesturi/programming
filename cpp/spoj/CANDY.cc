#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    while (true) {
        cin >> n;
        if (n == -1) break;
        vector<int> candies(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cin >> candies[i];
            sum += candies[i];
        }
        if (sum % n == 0) {
            int average = sum / n, result = 0;
            for (int i = 0; i < n; i++) {
                if (candies[i] < average) {
                    result += average - candies[i];
                }
            }
            cout << result << "\n";
        } else {
            cout << "-1\n";
        }
    }
    return 0;
}
