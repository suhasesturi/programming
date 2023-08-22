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

    int t, temp;
    string op = "";
    cin >> t;
    while (t-- > 0) {
        getline(cin, op);
        long long result = 0;
        for (int i = 0;; i++) {
            if (i % 2 == 0) {
                cin >> temp;
                if (i == 0)
                    result = temp;
                else {
                    if (op == "+") {
                        result = result + temp;
                    } else if (op == "-") {
                        result = result - temp;
                    } else if (op == "*") {
                        result = result * temp;
                    } else if (op == "/") {
                        result = result / temp;
                    }
                }
            } else {
                cin >> op;
            }
            if (op == "=") break;
        }
        cout << result << "\n";
    }
    return 0;
}
