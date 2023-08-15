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
        operations.resize(2 * size, 0LL);
        values.resize(2 * size, 0LL);
    }

    long long calc(int l, int r) { return calc(l, r, 0, 0, size); }

    void add(int l, int r, int v) { add(l, r, v, 0, 0, size); }

   private:
    void add(int l, int r, int v, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return;
        if (l <= lx && r >= rx) {
            operations[x] += v;
            values[x] += (rx - lx) * v;
            return;
        }
        int mid = (lx + rx) / 2;
        add(l, r, v, 2 * x + 1, lx, mid);
        add(l, r, v, 2 * x + 2, mid, rx);
        values[x] =
            (values[2 * x + 1] + values[2 * x + 2]) * (rx - lx) * operations[x];
    }

    long long calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return 0;
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        long long sum1 = calc(l, r, 2 * x + 1, lx, mid);
        long long sum2 = calc(l, r, 2 * x + 2, mid, rx);
        return (sum1 + sum2) + (rx - lx) * operations[x];
    }

    int size;
    vector<long long> operations, values;
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
            int op, l, r, v;
            cin >> op >> l >> r;
            l--;
            if (op == 0) {
                cin >> v;
                st.add(l, r, v);
            } else {
                cout << st.calc(l, r) << "\n";
            }
        }
    }

    return 0;
}
