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

struct Node {
    int parent;
    vector<int> children;
};

int lca(int a, int b, int root, vector<Node>& nodes) {
    if (root == a || root == b) return root;
    vector<int> result(nodes[root].children.size(), 0);
    for (int i = 0; i < result.size(); i++) {
        result[i] = lca(a, b, nodes[root].children[i], nodes);
    }
    int count = 0, lca_node;
    for (int i = 0; i < result.size(); i++) {
        if (result[i] != 0) {
            count++;
            lca_node = result[i];
        }
    }
    if (count == 2)
        return root;
    else if (count == 1)
        return lca_node;
    else
        return 0;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    for (int t = 1; t <= T; t++) {
        int n, m, q, temp, a, b;
        cin >> n;
        vector<Node> nodes(n + 1, {-1, vector<int>()});
        for (int i = 1; i <= n; i++) {
            cin >> m;
            for (int j = 0; j < m; j++) {
                cin >> temp;
                nodes[i].children.push_back(temp);
                nodes[temp].parent = i;
            }
        }
        int root;
        for (int i = 1; i <= n; i++) {
            if (nodes[i].parent == -1) {
                root = i;
                break;
            }
        }

        cin >> q;
        cout << "Case " << t << ":\n";
        while (q-- > 0) {
            cin >> a >> b;
            cout << lca(a, b, root, nodes) << "\n";
        }
    }
    return 0;
}
