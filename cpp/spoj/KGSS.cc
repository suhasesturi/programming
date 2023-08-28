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
    vector<int> max_entries;
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

    item calc(int l, int r) { return calc(l, r, 0, 0, size); }

    void set(int i, int val) { set(i, val, 0, 0, size); }

   private:
    void set(int i, int val, int x, int lx, int rx) {
        if (rx - lx == 1) {
            values[x].max_entries[0] = val;
            return;
        }
        int mid = (lx + rx) / 2;
        if (i < mid) {
            set(i, val, 2 * x + 1, lx, mid);
        } else {
            set(i, val, 2 * x + 2, mid, rx);
        }
        merge(values[2 * x + 1], values[2 * x + 2], values[x].max_entries);
    }

    void build(vector<int>& arr, int x, int lx, int rx) {
        if (rx - lx == 1) {
            if (lx < arr.size()) {
                values[x] = {vector<int>(1, arr[lx])};
            }
            return;
        }
        int m = (lx + rx) / 2;
        build(arr, 2 * x + 1, lx, m);
        build(arr, 2 * x + 2, m, rx);

        item node;
        node.max_entries = vector<int>(2);
        merge(values[2 * x + 1], values[2 * x + 2], node.max_entries);
        values[x] = node;
    }

    void merge(item a, item b, vector<int>& result) {
        int i = 0, j = 0, k = 0;
        while (i < a.max_entries.size() && j < b.max_entries.size() && k < 2) {
            if (a.max_entries[i] <= b.max_entries[j]) {
                result[k++] = b.max_entries[j++];
            } else {
                result[k++] = a.max_entries[i++];
            }
        }
        while (i < a.max_entries.size() && k < 2) {
            result[k++] = a.max_entries[i++];
        }
        while (j < b.max_entries.size() && k < 2) {
            result[k++] = b.max_entries[j++];
        }
    }

    item calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return {vector<int>()};
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        item result;
        result.max_entries = vector<int>(2, 0);
        merge(calc(l, r, 2 * x + 1, lx, mid), calc(l, r, 2 * x + 2, mid, rx),
              result.max_entries);
        return result;
    }

    int size;
    vector<item> values;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    SegTree st(n);
    st.build(arr);

    int q;
    cin >> q;
    while (q-- > 0) {
        char op;
        cin >> op;
        if (op == 'Q') {
            int l, r, sum = 0;
            cin >> l >> r;
            l--;
            item result = st.calc(l, r);
            for (int i = 0; i < result.max_entries.size(); i++) {
                sum += result.max_entries[i];
            }
            cout << sum << "\n";
        } else {
            int i, x;
            cin >> i >> x;
            i--;
            st.set(i, x);
        }
    }
}
