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

    int t;
    cin >> t;
    while (t-- > 0) {
        double a, b, c, d;
        cin >> a >> b >> c >> d;
        double semi_perimeter = (a + b + c + d) / 2;
        double result = sqrt((semi_perimeter - a) * (semi_perimeter - b) *
                             (semi_perimeter - c) * (semi_perimeter - d));
        printf("%.2f\n", result);
    }
    return 0;
}
