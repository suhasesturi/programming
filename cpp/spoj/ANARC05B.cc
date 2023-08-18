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

bool find(int a, vector<int>& arr) {
    int start = 0, end = arr.size() - 1, mid;
    while (start <= end) {
        mid = (start + end) / 2;
        if (arr[mid] == a) return true;
        if (arr[mid] < a)
            start = mid + 1;
        else
            end = mid - 1;
    }
    return false;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    while (true) {
        int n, m;
        cin >> n;
        if (n == 0) break;

        vector<int> first(n);
        for (int i = 0; i < n; i++) {
            cin >> first[i];
        }

        cin >> m;
        vector<int> second(m);
        for (int i = 0; i < m; i++) {
            cin >> second[i];
        }

        vector<long long> a, b;
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += first[i];
            if (find(first[i], second)) {
                a.push_back(sum);
                sum = 0;
            }
        }
        if (sum != 0) {
            a.push_back(sum);
        }

        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += second[i];
            if (find(second[i], first)) {
                b.push_back(sum);
                sum = 0;
            }
        }
        if (sum != 0) {
            b.push_back(sum);
        }

        sum = 0;
        int i, j;
        for (i = 0, j = 0; i < a.size() && j < b.size(); i++, j++) {
            sum += max(a[i], b[j]);
        }
        if (i < a.size() && a.back() > 0) {
            sum += a.back();
        } else if (j < b.size() && b.back() > 0) {
            sum += b.back();
        }
        cout << sum << "\n";
    }

    return 0;
}
