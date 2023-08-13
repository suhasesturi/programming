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
    int sum, index;
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

    item calc(int k, int l, int r) { return calc(k, l, r, 0, 0, size); }

    item NEUTRAL_ELEMNT = {0, -1};

    item merge(item a, item b) { return {a.sum + b.sum, -1}; }

   private:
    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                values[x] = {arr[lx]};
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
            values[x].sum = v == -1 ? 1 - values[x].sum : v;
            values[x].index = i;
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

    item calc(int k, int l, int r, int x, int lx, int rx) {
        // if (l >= rx || r <= lx) return NEUTRAL_ELEMNT;
        // if (l <= lx && r >= rx) return values[x];
        if (rx - lx == 1) {
            return values[x];
        }
        int mid = (lx + rx) / 2;

        if (values[2 * x + 1].sum > k) {
            return calc(k, l, r, 2 * x + 1, lx, mid);
        } else {
            return calc(k - values[2 * x + 1].sum, l, r, 2 * x + 2, mid, rx);
        }
    }

    int size;
    vector<item> values;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, temp;
    cin >> n >> m;
    SegTree st(n);
    for (int i = 0; i < n; i++) {
        cin >> temp;
        st.set(i, temp);
    }

    while (m-- > 0) {
        int op, index;
        cin >> op >> index;
        if (op == 1) {
            st.set(index, -1);
        } else {
            cout << st.calc(index, 0, n).index << "\n";
        }
    }

    return 0;
}
