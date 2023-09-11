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

int i_val[] = {-1, 0, 1, 0};
int j_val[] = {0, 1, 0, -1};

void dfs(int i, int j, int current, vector<vector<int>>& blocks,
         vector<vector<int>>& distance) {
    distance[i][j] = current;

    for (int index = 0; index < 4; index++) {
        if ((i + i_val[index] >= 0) && (i + i_val[index] < blocks.size()) &&
            (j + j_val[index] >= 0) && (j + j_val[index] < blocks[0].size())) {
            if (blocks[i + i_val[index]][j + j_val[index]] == 1 &&
                distance[i + i_val[index]][j + j_val[index]] == -1) {
                dfs(i + i_val[index], j + j_val[index], current + 1, blocks,
                    distance);
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int c, r;
        string s;
        cin >> c >> r;
        int start_i = -1, start_j = -1;
        vector<vector<int>> blocks(r, vector<int>(c));
        for (int i = 0; i < r; i++) {
            cin >> s;
            for (int j = 0; j < c; j++) {
                blocks[i][j] = s[j] == '#' ? 0 : 1;
                if (blocks[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                }
            }
        }

        vector<vector<int>> distance(r, vector<int>(c, -1));
        dfs(start_i, start_j, 0, blocks, distance);
        start_i = -1, start_j = -1;
        int farthest = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (distance[i][j] >= farthest) {
                    farthest = distance[i][j];
                    start_i = i;
                    start_j = j;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            fill(distance[i].begin(), distance[i].end(), -1);
        }

        dfs(start_i, start_j, 0, blocks, distance);
        farthest = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (distance[i][j] >= farthest) {
                    farthest = distance[i][j];
                }
            }
        }
        cout << "Maximum rope length is " << farthest << ".\n";
    }

    return 0;
}
