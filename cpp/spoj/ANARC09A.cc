#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
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

    for (int i = 1; true; i++) {
        string s;
        cin >> s;
        if (s[0] == '-') break;
        int result = 0, count = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s[j] == '{') {
                count++;
            } else {
                if (count == 0) {
                    count++;
                    result++;
                } else {
                    count--;
                }
            }
        }
        cout << i << ". " << result + count / 2 << "\n";
    }

    return 0;
}
