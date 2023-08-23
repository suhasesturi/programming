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

bool within_limits(int a, int b) { return a >= 0 && a < 8 && b >= 0 && b < 8; }

int bfs(string start, string end, vector<vector<int>>& board) {
    int x, y, a, b;
    x = start[0] - 'a';
    y = start[1] - '1';
    a = end[0] - 'a';
    b = end[1] - '1';

    deque<int> dq;
    dq.push_back(x);
    dq.push_back(y);
    dq.push_back(0);
    board[x][y] = 0;
    while (!dq.empty()) {
        int i, j, d;
        i = dq.front();
        dq.pop_front();
        j = dq.front();
        dq.pop_front();
        d = dq.front();
        dq.pop_front();

        if (i == a && j == b) return d;

        int list_i[] = {i - 2, i - 1, i + 1, i + 2, i + 2, i + 1, i - 1, i - 2};
        int list_j[] = {j + 1, j + 2, j + 2, j + 1, j - 1, j - 2, j - 2, j - 1};

        for (int k = 0; k < 8; k++) {
            if (within_limits(list_i[k], list_j[k]) &&
                board[list_i[k]][list_j[k]] == -1) {
                dq.push_back(list_i[k]);
                dq.push_back(list_j[k]);
                dq.push_back(d + 1);
            }
        }
    }

    return -1;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    vector<vector<int>> board(8, vector<int>(8, -1));
    while (t-- > 0) {
        string start, end;
        cin >> start >> end;
        cout << bfs(start, end, board) << "\n";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = -1;
            }
        }
    }
    return 0;
}
