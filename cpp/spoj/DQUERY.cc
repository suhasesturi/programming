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
    vector<int> values;
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

    int calc(int l, int r) { return calc(l, r, 0, 0, size); }

    void merge(item a, item b, vector<int>& result) {
        int i = 0, j = 0, k = 0;
        while (i < a.values.size() && j < b.values.size()) {
            if (a.values[i] <= b.values[j]) {
                result[k++] = a.values[i++];
            } else {
                result[k++] = b.values[j++];
            }
        }
        while (i < a.values.size()) {
            result[k++] = a.values[i++];
        }
        while (j < b.values.size()) {
            result[k++] = b.values[j++];
        }
    }

   private:
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
        node.values = vector<int>(values[2 * x + 1].values.size() +
                                  values[2 * x + 2].values.size());
        merge(values[2 * x + 1], values[2 * x + 2], node.values);
        values[x] = node;
    }

    int bs(vector<int>& arr, int r) {
        int start = 0, end = arr.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= r) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return arr.size() - start;
    }

    int calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return 0;
        if (l <= lx && r >= rx) return bs(values[x].values, r);
        int mid = (lx + rx) / 2;
        return calc(l, r, 2 * x + 1, lx, mid) + calc(l, r, 2 * x + 2, mid, rx);
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
    map<int, int> last_index;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }
    for (int i = n - 1; i >= 0; i--) {
        if (last_index.count(arr[i]) == 0) {
            last_index[arr[i]] = i;
            arr[i] = INT32_MAX;
        } else {
            int temp = arr[i];
            arr[i] = last_index[arr[i]];
            last_index[temp] = i;
        }
    }
    SegTree st(n);
    st.build(arr);

    int q;
    cin >> q;
    while (q-- > 0) {
        int l, r;
        cin >> l >> r;
        l--;
        cout << st.calc(l, r) << "\n";
    }
}
