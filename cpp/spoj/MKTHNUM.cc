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
  vector<int> elements;
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

  void build(vector<pair<int, int>> &arr) { build(arr, 0, 0, size); }

  int calc(int l, int r, int k) { return calc(l, r, k, 0, 0, size); }

  void merge(item a, item b, vector<int> &result) {
    int i = 0, j = 0, k = 0;
    while (i < a.elements.size() && j < b.elements.size()) {
      if (a.elements[i] <= b.elements[j]) {
        result[k++] = a.elements[i++];
      } else {
        result[k++] = b.elements[j++];
      }
    }
    while (i < a.elements.size()) {
      result[k++] = a.elements[i++];
    }
    while (j < b.elements.size()) {
      result[k++] = b.elements[j++];
    }
  }

 private:
  void build(vector<pair<int, int>> &arr, int x, int lx, int rx) {
    if (rx - lx == 1) {
      if (lx < arr.size()) {
        values[x] = {vector<int>(1, arr[lx].second)};
      }
      return;
    }
    int m = (lx + rx) / 2;
    build(arr, 2 * x + 1, lx, m);
    build(arr, 2 * x + 2, m, rx);

    item node;
    node.elements = vector<int>(values[2 * x + 1].elements.size() +
                                values[2 * x + 2].elements.size());
    merge(values[2 * x + 1], values[2 * x + 2], node.elements);
    values[x] = node;
  }

  int calc(int l, int r, int k, int x, int lx, int rx) {
    if (rx - lx == 1) {
      return values[x].elements[0];
    }
    int p = upper_bound(values[2 * x + 1].elements.begin(),
                        values[2 * x + 1].elements.end(), r) -
            lower_bound(values[2 * x + 1].elements.begin(),
                        values[2 * x + 1].elements.end(), l);
    int mid = (lx + rx) / 2;
    if (p >= k) {
      return calc(l, r, k, 2 * x + 1, lx, mid);
    } else {
      return calc(l, r, k - p, 2 * x + 2, mid, rx);
    }
  }

  int size;
  vector<item> values;
};

int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);

  int n, m;
  cin >> n >> m;
  vector<pair<int, int>> input(n);
  vector<int> arr(n);
  for (int i = 0; i < n; i++) {
    cin >> input[i].first;
    arr[i] = input[i].first;
    input[i].second = i;
  }
  sort(input.begin(), input.end());
  SegTree st(n);
  st.build(input);

  while (m-- > 0) {
    int l, r, k;
    cin >> l >> r >> k;
    l--; r--;
    cout << arr[st.calc(l, r, k)] << "\n";
  }
}
