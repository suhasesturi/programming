#include <math.h>
#include <stdint.h>

#include <algorithm>
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

    int t;
    cin >> t;
    while (t-- > 0) {
        int h, w;
        cin >> h >> w;
        vector<vector<int>> tiles(h + 2, vector<int>(w + 2, 0));
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                cin >> tiles[i][j];
            }
        }
        for (int i = 2; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                tiles[i][j] += max(max(tiles[i - 1][j - 1], tiles[i - 1][j]),
                                   tiles[i - 1][j + 1]);
            }
        }
        int result = 0;
        for (int j = 1; j <= w; j++) {
            result = max(result, tiles[h][j]);
        }
        cout << result << "\n";
    }
    return 0;
}
