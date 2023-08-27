#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
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

    int n;
    string s;
    cin >> n;
    int half = 0, one_fourth = 0, three_fourth = 0;
    while (n-- > 0) {
        cin >> s;
        if (s.compare("1/2") == 0)
            half++;
        else if (s.compare("1/4") == 0)
            one_fourth++;
        else
            three_fourth++;
    }
    int result = 1;
    result += three_fourth;
    one_fourth = max(0, one_fourth - three_fourth);
    result += half / 2;
    if (half % 2 == 1) {
        one_fourth = max(0, one_fourth - 2);
        result++;
    }
    result += (int)ceil(one_fourth / 4.0);
    cout << result << "\n";

    return 0;
}
