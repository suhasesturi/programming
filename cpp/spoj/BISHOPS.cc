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

    string s;
    while (cin >> s) {
        if (s == "1") {
            cout << "1\n";
            continue;
        }
        int carry = -1;
        for (int i = s.length() - 1; i >= 0 && carry == -1; i--) {
            if (s[i] == '0') {
                s[i] = '9';
            } else {
                s[i]--;
                carry = 0;
            }
        }
        carry = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char mul[] = {'0', '2', '4', '6', '8', '0', '2', '4', '6', '8'};
            char temp = mul[s[i] - '0'] + carry;
            if (s[i] >= '5') {
                carry = 1;
            } else {
                carry = 0;
            }
            s[i] = temp;
        }
        if (carry == 1) {
            s = "1" + s;
        }

        cout << s << "\n";
    }

    return 0;
}
