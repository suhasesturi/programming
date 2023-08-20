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

/*
Explanation:

AB^2 + AC^2 = BC^2 - since triangle in semi circle is right angled.
AB^2 + AC^2 = (2r)^2
AB^2 = (2r)^2 - AC^2 

S = AB^2 + AC
S = (2r)^2 - AC^2 + AC
S = -AC^2 + AC + 4r^2
diffentiate with AC to get maxima
0 = -2AC + 1 + 0
AC = 1 / 2

AB^2 = (2r)^2 - AC^2 
AB^2 = 4r^2 - 1 / 4

S = AB^2 + AC
S = 4r^2 - 1 / 4 + 1 / 2
S = 4r^2 + 1 / 4 - answer
*/

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t, count = 1;
    cin >> t;
    while (t-- > 0) {
        long long n;
        cin >> n;
        printf("Case %d: %.2f\n", count, 4 * n * n + 0.25);
        count++;
    }
    return 0;
}
