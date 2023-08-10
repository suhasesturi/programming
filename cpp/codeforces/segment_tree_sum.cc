#include <math.h>

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
        sums.assign(2 * size, 0LL);
    }

    void build(vector<int>& arr) { build(arr, 0, 0, size); }

    void set(int i, int v) { set(i, v, 0, 0, size); }

    long long sum(int l, int r) { return sum(l, r, 0, 0, size); }

   private:
    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                sums[x] = arr[lx];
            }
            return;
        }
        int mid = (lx + rx) / 2;
        build(arr, 2 * x + 1, lx, mid);
        build(arr, 2 * x + 2, mid, rx);
        sums[x] = sums[2 * x + 1] + sums[2 * x + 2];
    }

    void set(int i, int v, int x, int lx, int rx) {
        if (rx - lx == 1) {
            sums[x] = v;
            return;
        }
        int m = (lx + rx) / 2;
        if (i < m) {
            set(i, v, 2 * x + 1, lx, m);
        } else {
            set(i, v, 2 * x + 2, m, rx);
        }
        sums[x] = sums[2 * x + 1] + sums[2 * x + 2];
    }

    long long sum(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return 0;
        if (l <= lx && r >= rx) return sums[x];
        int m = (lx + rx) / 2;
        long long s1 = sum(l, r, 2 * x + 1, lx, m);
        long long s2 = sum(l, r, 2 * x + 2, m, rx);
        return s1 + s2;
    }

    int size;
    vector<long long> sums;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;
    SegTree sg(n);
    vector<int> arr(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    sg.build(arr);

    while (m-- > 0) {
        int op;
        cin >> op;
        if (op == 1) {
            int i, v;
            cin >> i >> v;
            sg.set(i, v);
        } else {
            int l, r;
            cin >> l >> r;
            cout << sg.sum(l, r) << "\n";
        }
    }

    return 0;
}
