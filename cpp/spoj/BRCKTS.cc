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

class SegTree {
   public:
    SegTree(int n) {
        size = 1;
        while (size < n) {
            size *= 2;
        }
        values.resize(2 * size, 0);
        operations.resize(2 * size, 0);
    }

    void build(vector<int>& arr) { build(arr, 0, 0, size); }

    void add(int val, int l, int r) { add(val, l, r, 0, 0, size); }

    int calc(int l, int r) { return calc(l, r, 0, 0, size); }

   private:
    void add(int val, int l, int r, int x, int lx, int rx) {
        if (lx >= r || rx <= l) return;
        if (l <= lx && r >= rx) {
            operations[x] += val;
            values[x] += val;
            return;
        }
        int mid = (lx + rx) / 2;
        add(val, l, r, 2 * x + 1, lx, mid);
        add(val, l, r, 2 * x + 2, mid, rx);
        values[x] = min(values[2 * x + 1], values[2 * x + 2]) + operations[x];
    }

    int calc(int l, int r, int x, int lx, int rx) {
        if (lx >= r || rx <= l) return INT32_MAX;
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        return min(calc(l, r, 2 * x + 1, lx, mid),
                   calc(l, r, 2 * x + 2, mid, rx)) +
               operations[x];
    }

    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                values[x] = arr[lx];
            }
            return;
        }
        int mid = (lx + rx) / 2;
        build(arr, 2 * x + 1, lx, mid);
        build(arr, 2 * x + 2, mid, rx);
        values[x] = min(values[2 * x + 1], values[2 * x + 2]);
    }

    int size;
    vector<int> values;
    vector<int> operations;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int t = 1; t <= 10; t++) {
        int n, m, index;
        cin >> n;
        string s;
        cin >> s;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            arr[i] = (s[i] == '(' ? 1 : -1) + (i == 0 ? 0 : arr[i - 1]);
        }
        SegTree st(n);
        st.build(arr);

        cout << "Test " << t << ":\n";
        cin >> m;
        while (m-- > 0) {
            cin >> index;
            if (index == 0) {
                if (st.calc(0, n) == 0 && st.calc(n - 1, n) == 0) {
                    cout << "YES\n";
                } else {
                    cout << "NO\n";
                }
            } else {
                index--;
                if (s[index] == '(') {
                    s[index] = ')';
                    st.add(-2, index, n);
                } else {
                    s[index] = '(';
                    st.add(2, index, n);
                }
            }
        }
    }
    return 0;
}
