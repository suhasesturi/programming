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

class SegTree {
   public:
    SegTree(int n) {
        size = 1;
        while (size < n) {
            size *= 2;
        }
        values.assign(2 * size, INT32_MAX);
    }

    void build(vector<int>& arr) { build(arr, 0, 0, size); }

    void set(int i, int v) { set(i, v, 0, 0, size); }

    int calc(int l, int r) { return calc(l, r, 0, 0, size); }

   private:
    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                values[x] = arr[lx];
            }
            return;
        }
        int m = (lx + rx) / 2;
        build(arr, 2 * x + 1, lx, m);
        build(arr, 2 * x + 2, m, rx);
        values[x] = min(values[2 * x + 1], values[2 * x + 2]);
    }

    void set(int i, int v, int x, int lx, int rx) {
        if (rx - lx == 1) {
            values[x] = v;
            return;
        }
        int m = (lx + rx) / 2;
        if (i < m) {
            set(i, v, 2 * x + 1, lx, m);
        } else {
            set(i, v, 2 * x + 2, m, rx);
        }
        values[x] = min(values[2 * x + 1], values[2 * x + 2]);
    }

    int calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return INT32_MAX;
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        return min(calc(l, r, 2 * x + 1, lx, mid),
                   calc(l, r, 2 * x + 2, mid, rx));
    }

    int size;
    vector<int> values;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    SegTree st(n);
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    st.build(arr);

    while (m-- > 0) {
        int op;
        cin >> op;
        if (op == 1) {
            int i, v;
            cin >> i >> v;
            st.set(i, v);
        } else {
            int l, r;
            cin >> l >> r;
            cout << st.calc(l, r) << "\n";
        }
    }

    return 0;
}
