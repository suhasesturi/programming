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

int modulo(string& s, int x) {
    int current = 0;
    for (int i = 0; i < s.length(); i++) {
        current = current * 10 + s[i] - '0';
        if (current < x) {
            s[i] = '0';
        } else {
            s[i] = current / x + '0';
            current = current % x;
        }
    }
    return current;
}

bool at_least(string& s, int x) {
    long long sum = 0;
    for (int i = 0; i < s.length(); i++) {
        sum = sum * 10 + s[i] - '0';
        if (sum >= x) {
            return true;
        }
    }
    return false;
}

int get_digit_root(int x) {
    while (x >= 10) {
        int temp = 0;
        while (x > 0) {
            temp += x % 10;
            x /= 10;
        }
        x = temp;
    }
    return x;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string a, b;
    cin >> a >> b;
    int sum = 0;
    for (char ch : a) {
        sum += ch - '0';
    }
    sum = get_digit_root(sum);

    vector<vector<int>> dp = {{0},    {1},       {1, 2, 4, 8, 7, 5},
                              {3, 9}, {1, 4, 7}, {1, 5, 7, 8, 4, 2},
                              {6, 9}, {1, 7, 4}, {1, 8},
                              {9}};

    if (sum == 1 || sum == 9) {
        cout << sum;
    } else if (sum == 2 || sum == 5) {
        cout << dp[sum][modulo(b, 6)];
    } else if (sum == 3 || sum == 6) {
        cout << (at_least(b, 2) ? 9 : sum);
    } else if (sum == 4 || sum == 7) {
        cout << dp[sum][modulo(b, 3)];
    } else if (sum == 8) {
        cout << dp[sum][modulo(b, 2)];
    }

    return 0;
}
