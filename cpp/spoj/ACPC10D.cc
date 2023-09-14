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
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, t = 1;
    while (true) {
        cin >> n;
        if (n == 0) break;
        vector<vector<long long>> matrix(n, vector<long long>(3));
        for (int i = 0; i < n; i++) {
            cin >> matrix[i][0] >> matrix[i][1] >> matrix[i][2];
        }
        matrix[0][0] = INT64_MAX - 1;
        matrix[0][2] += matrix[0][1];

        long long temp = INT64_MAX;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                temp = INT64_MAX;
                if (j - 1 >= 0) temp = min(temp, matrix[i - 1][j - 1]);
                temp = min(temp, matrix[i - 1][j]);
                if (j + 1 <= 2) temp = min(temp, matrix[i - 1][j + 1]);
                if (j - 1 >= 0) temp = min(temp, matrix[i][j - 1]);
                matrix[i][j] += temp == INT64_MAX ? 0 : temp;
            }
        }
        cout << t++ << ". " << matrix[n - 1][1] << "\n";
    }

    return 0;
}
