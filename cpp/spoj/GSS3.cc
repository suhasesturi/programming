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

struct item {
    long long seg, pref, suf, sum;
};

class SegTree {
   public:
    SegTree(int n) {
        size = 1;
        while (size < n) {
            size *= 2;
        }
        values.resize(2 * size);
    }

    void build(vector<int>& arr) { build(arr, 0, 0, size); }

    void set(int i, int v) { set(i, v, 0, 0, size); }

    item calc(int l, int r) { return calc(l, r, 0, 0, size); }

    item NEUTRAL_ELEMNT = {INT32_MIN, INT32_MIN, INT32_MIN, INT32_MIN};

    item single(int value) { return {value, value, value, value}; }

    item merge(item a, item b) {
        return {max(max(a.seg, b.seg), a.suf + b.pref),
                max(a.pref, a.sum + b.pref), max(b.suf, b.sum + a.suf),
                a.sum + b.sum};
    }

   private:
    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                values[x] = single(arr[lx]);
            }
            return;
        }
        int m = (lx + rx) / 2;
        build(arr, 2 * x + 1, lx, m);
        build(arr, 2 * x + 2, m, rx);
        values[x] = merge(values[2 * x + 1], values[2 * x + 2]);
    }

    void set(int i, int v, int x, int lx, int rx) {
        if (rx - lx == 1) {
            values[x] = single(v);
            return;
        }
        int m = (lx + rx) / 2;
        if (i < m) {
            set(i, v, 2 * x + 1, lx, m);
        } else {
            set(i, v, 2 * x + 2, m, rx);
        }
        values[x] = merge(values[2 * x + 1], values[2 * x + 2]);
    }

    item calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return NEUTRAL_ELEMNT;
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        return merge(calc(l, r, 2 * x + 1, lx, mid),
                     calc(l, r, 2 * x + 2, mid, rx));
    }

    int size;
    vector<item> values;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n;
    SegTree st(n);
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    st.build(arr);

    cin >> m;
    while (m-- > 0) {
        int op, l, r, i, v;
        cin >> op;
        if (op == 0) {
            cin >> i >> v;
            st.set(--i, v);
        } else {
            cin >> l >> r;
            cout << st.calc(--l, r).seg << "\n";
        }
    }

    return 0;
}
