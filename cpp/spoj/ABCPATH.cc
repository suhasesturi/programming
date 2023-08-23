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

struct Next {
    int x, y;
    char ch;
};

bool within_limits(int i, int j, int h, int w) {
    return i >= 0 && i < h && j >= 0 && j < w;
}

void max_path(int x, int y, vector<string>& matrix,
              vector<vector<int>>& distance) {
    distance[x][y] = 1;
    deque<Next> dq;
    dq.push_back({x, y, 'B'});

    int i, j;
    while (!dq.empty()) {
        Next next_elem = dq.front();
        dq.pop_front();
        i = next_elem.x;
        j = next_elem.y;

        int list_i[] = {i - 1, i - 1, i, i + 1, i + 1, i + 1, i, i - 1};
        int list_j[] = {j, j + 1, j + 1, j + 1, j, j - 1, j - 1, j - 1};
        for (int k = 0; k < 8; k++) {
            if (within_limits(list_i[k], list_j[k], matrix.size(),
                              matrix[0].size()) &&
                matrix[list_i[k]][list_j[k]] == next_elem.ch &&
                distance[list_i[k]][list_j[k]] == -1) {
                distance[list_i[k]][list_j[k]] = distance[i][j] + 1;
                dq.push_back({list_i[k], list_j[k], (char)(next_elem.ch + 1)});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int h, w, t = 1;
    while (true) {
        cin >> h >> w;
        if (h == 0 && w == 0) break;

        vector<string> matrix(h);
        vector<vector<int>> distance(h, vector<int>(w, -1));
        for (int i = 0; i < h; i++) {
            cin >> matrix[i];
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] == 'A') {
                    max_path(i, j, matrix, distance);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result = max(result, distance[i][j]);
            }
        }
        cout << "Case " << t++ << ": " << result << "\n";
    }

    return 0;
}
