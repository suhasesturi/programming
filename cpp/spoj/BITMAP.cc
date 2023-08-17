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

bool in_range(int x, int y, int n, int m) {
    return x >= 0 && x < n && y >= 0 && y < m;
}

void calculate(int i, int j, int n, int m, char matrix[182][182],
               int distance[182][182]) {
    deque<int> dq;
    distance[i][j] = 0;
    dq.push_back(i);
    dq.push_back(j);

    int x, y;
    while (!dq.empty()) {
        x = dq.front();
        dq.pop_front();
        y = dq.front();
        dq.pop_front();

        if (in_range(x, y - 1, n, m) &&
            distance[x][y - 1] > distance[x][y] + 1) {
            if (matrix[x][y - 1] == '1')
                distance[x][y - 1] = 0;
            else
                distance[x][y - 1] = distance[x][y] + 1;
            dq.push_back(x);
            dq.push_back(y - 1);
        }
        if (in_range(x, y + 1, n, m) &&
            distance[x][y + 1] > distance[x][y] + 1) {
            if (matrix[x][y + 1] == '1')
                distance[x][y + 1] = 0;
            else
                distance[x][y + 1] = distance[x][y] + 1;
            dq.push_back(x);
            dq.push_back(y + 1);
        }

        if (in_range(x - 1, y, n, m) &&
            distance[x - 1][y] > distance[x][y] + 1) {
            if (matrix[x - 1][y] == '1')
                distance[x - 1][y] = 0;
            else
                distance[x - 1][y] = distance[x][y] + 1;
            dq.push_back(x - 1);
            dq.push_back(y);
        }
        if (in_range(x + 1, y, n, m) &&
            distance[x + 1][y] > distance[x][y] + 1) {
            if (matrix[x + 1][y] == '1')
                distance[x + 1][y] = 0;
            else
                distance[x + 1][y] = distance[x][y] + 1;
            dq.push_back(x + 1);
            dq.push_back(y);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    char matrix[182][182];
    int distance[182][182];
    while (t-- > 0) {
        int n, m;
        cin >> n >> m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> matrix[i][j];
                distance[i][j] = INT32_MAX;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1' && distance[i][j] == INT32_MAX) {
                    calculate(i, j, n, m, matrix, distance);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cout << distance[i][j] << " ";
            }
            cout << "\n";
        }
    }
    return 0;
}
