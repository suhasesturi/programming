#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    string input;
    while (true) {
        cin >> input;
        if (input == "0") break;
        vector<long long> dp(input.length(), 1);
        for (int i = 1; i < input.length(); i++) {
            if (input[i] == '0') {
                dp[i] = (i - 2) >= 0 ? dp[i - 2] : 1;
            } else {
                if (input[i - 1] == '1' ||
                    (input[i - 1] == '2' && input[i] <= '6')) {
                    dp[i] = dp[i - 1] + ((i - 2) >= 0 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        cout << dp[input.length() - 1] << "\n";
    }

    return 0;
}
