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

string convert(int n) {
    string result = "";
    vector<int> binary_notation;
    for (int i = 0; n > 0; i++) {
        binary_notation.push_back(n % 2);
        n /= 2;
    }
    for (int i = binary_notation.size() - 1; i >= 0; i--) {
        if (binary_notation[i] != 0) {
            if (i == 0)
                result += "2(0)+";
            else if (i == 1)
                result += "2+";
            else {
                result += "2(" + convert(i) + ")+";
            }
        }
    }
    return result.substr(0, result.size() - 1);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int query[] = {137, 1315, 73, 136, 255, 1384, 16385};
    for (int i = 0; i < 7; i++) {
        cout << query[i] << "=" << convert(query[i]) << "\n";
    }
    return 0;
}
