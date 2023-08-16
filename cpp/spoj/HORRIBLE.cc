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
    long long sum;
    int num_elements;
};

class SegTree {
   public:
    SegTree(int n) {
        size = 1;
        while (size < n) {
            size *= 2;
        }
        operations.resize(2 * size, 0LL);
        values.resize(2 * size, {0LL, 0});
    }

    item calc(int l, int r) { return calc(l, r, 0, 0, size); }

    void add(int l, int r, long long v) { add(l, r, v, 0, 0, size); }

   private:
    void add(int l, int r, long long v, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return;
        if (l <= lx && r >= rx) {
            operations[x] += v;
            values[x].sum += (rx - lx) * v;
            return;
        }
        int mid = (lx + rx) / 2;
        add(l, r, v, 2 * x + 1, lx, mid);
        add(l, r, v, 2 * x + 2, mid, rx);
        values[x].sum = (values[2 * x + 1].sum + values[2 * x + 2].sum) +
                        (rx - lx) * operations[x];
    }

    item calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return {0, 0};
        if (l <= lx && r >= rx) {
            return {values[x].sum, rx - lx};
        }
        int mid = (lx + rx) / 2;
        item val1 = calc(l, r, 2 * x + 1, lx, mid);
        item val2 = calc(l, r, 2 * x + 2, mid, rx);
        return {val1.sum + val2.sum +
                    (val1.num_elements + val2.num_elements) * operations[x],
                val1.num_elements + val2.num_elements};
    }

    int size;
    vector<long long> operations;
    vector<item> values;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, c;
        cin >> n >> c;
        SegTree st(n);
        while (c-- > 0) {
            int op, l, r;
            long long v;
            cin >> op >> l >> r;
            l--;
            if (op == 0) {
                cin >> v;
                st.add(l, r, v);
            } else {
                cout << st.calc(l, r).sum << "\n";
            }
        }
    }

    return 0;
}
