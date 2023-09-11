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
        values.resize(2 * size);
    }

    void set(int i, int v) { set(i, v, 0, 0, size); }

    long long calc(int l, int r) { return calc(l, r, 0, 0, size); }

   private:
    void set(int i, long long v, int x, int lx, int rx) {
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
        values[x] = max(values[2 * x + 1], values[2 * x + 2]);
    }

    long long calc(int l, int r, int x, int lx, int rx) {
        if (l >= rx || r <= lx) return INT32_MIN;
        if (l <= lx && r >= rx) return values[x];
        int mid = (lx + rx) / 2;
        return max(calc(l, r, 2 * x + 1, lx, mid),
                   calc(l, r, 2 * x + 2, mid, rx));
    }

    int size;
    vector<long long> values;
};

struct Edge {
    int to, w;
};

class Graph {
   public:
    Graph(int n) : st(n) {
        time = 0;
        size.resize(n, 0);
        depth.resize(n, 0);
        parent.resize(n, 0);
        big_child.resize(n, -1);
        label.resize(n, 0);
        parent_edge_weight.resize(n, 0);
        chain.resize(n);
        for (int i = 0; i < n; i++) {
            chain[i] = i;
        }
        ancestors.resize(n, vector<int>(ceil(log2(n)) + 1));
        edges.resize(n, vector<Edge>());
        tin.resize(n, 0);
        tout.resize(n, 0);
    }

    void initialize() {
        populate_size(0, 0, 0);
        assign_labels(0, 0);
        heavy_chain(0, 0);
        time = 0;
        calculate_ancestors(0, 0);
    }

    void add_edge(int a, int b, int weight) {
        edges[a].push_back({b, weight});
        edges[b].push_back({a, weight});
    }

    long long query(int u, int v) {
        int lc = lca(u, v);
        return max(query_chain(u, lc), query_chain(v, lc));
    }

    bool is_ancestor(int u, int v) {
        return tin[u] <= tin[v] && tout[u] >= tout[v];
    }

    SegTree st;
    vector<int> label;

   private:
    void assign_labels(int v, int p) {
        label[v] = time++;
        st.set(label[v], parent_edge_weight[v]);

        if (big_child[v] != -1) {
            assign_labels(big_child[v], v);
        }

        for (Edge e : edges[v]) {
            if (e.to != p && e.to != big_child[v]) {
                assign_labels(e.to, v);
            }
        }
    }

    void heavy_chain(int v, int p) {
        if (big_child[v] != -1) {
            chain[big_child[v]] = chain[v];
        }

        for (Edge e : edges[v]) {
            if (e.to != p) {
                heavy_chain(e.to, v);
            }
        }
    }

    long long query_chain(int v, int p) {
        long long result = 0;
        while (depth[v] > depth[p]) {
            int top = chain[v];
            if (depth[top] <= depth[p]) {
                top = kth_ancestor(v, depth[v] - depth[p] - 1);
            }
            result = max(result, st.calc(label[top], label[v] + 1));
            v = parent[top];
        }
        return result;
    }

    int kth_ancestor(int v, int k) {
        for (int i = ceil(log2(edges.size())); i >= 0 && k > 0; i--) {
            if ((1 << i) <= k) {
                v = ancestors[v][i];
                k -= (1 << i);
            }
        }
        return v;
    }

    void calculate_ancestors(int v, int p) {
        tin[v] = ++time;
        ancestors[v][0] = p;
        for (int i = 1; i <= ceil(log2(edges.size())); i++) {
            ancestors[v][i] = ancestors[ancestors[v][i - 1]][i - 1];
        }

        for (Edge e : edges[v]) {
            if (e.to != p) {
                calculate_ancestors(e.to, v);
            }
        }

        tout[v] = ++time;
    }

    int lca(int u, int v) {
        if (is_ancestor(u, v)) return u;
        if (is_ancestor(v, u)) return v;
        for (int i = ceil(log2(tin.size())); i >= 0; i--) {
            if (!is_ancestor(ancestors[u][i], v)) {
                u = ancestors[u][i];
            }
        }
        return ancestors[u][0];
    }

    void populate_size(int v, int p, int d) {
        size[v] = 1;
        depth[v] = d;
        parent[v] = p;
        int largest_child = -1, largest = -1;

        for (Edge e : edges[v]) {
            if (e.to != p) {
                parent_edge_weight[e.to] = e.w;
                populate_size(e.to, v, d + 1);
                size[v] += size[e.to];
                if (size[e.to] > largest) {
                    largest = size[e.to];
                    largest_child = e.to;
                }
            }
        }

        big_child[v] = largest_child;
    }

    int time;
    vector<int> size;
    vector<int> depth;
    vector<int> parent;
    vector<int> parent_edge_weight;
    vector<int> big_child;
    vector<int> chain;
    vector<int> tin, tout;
    vector<vector<int>> ancestors;
    vector<vector<Edge>> edges;
};

// solution explained at
// https://discuss.codechef.com/t/tutorial-heavy-light-decomposition/69423
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        vector<vector<int>> edges(n, vector<int>(3));
        Graph graph(n);
        int u, v, w;
        for (int i = 0; i < n - 1; i++) {
            cin >> u >> v >> w;
            u--;
            v--;
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = w;
            graph.add_edge(u, v, w);
        }
        graph.initialize();
        string s;
        int a, b;
        while (true) {
            cin >> s;
            if (s.compare("DONE") == 0) {
                break;
            } else if (s.compare("QUERY") == 0) {
                cin >> a >> b;
                a--;
                b--;
                cout << graph.query(a, b) << "\n";
            } else {
                cin >> a >> b;
                a--;
                if (graph.is_ancestor(edges[a][0], edges[a][1])) {
                    graph.st.set(graph.label[edges[a][1]], b);
                } else {
                    graph.st.set(graph.label[edges[a][0]], b);
                }
            }
        }
    }

    return 0;
}

/*
1
13
1 2 1
1 3 2
1 4 3
2 5 4
3 6 5
3 7 6
4 8 7
4 9 8
5 10 9
8 11 10
8 12 11
8 13 12
QUERY 4 10
*/