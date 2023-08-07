#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

vector<int> parent;
vector<int> node_rank;

int find(int x) {
    if (x != parent[x]) {
        parent[x] = find(parent[x]);
    }
    return parent[x];
}

void perform_union(int x, int y) {
    int a = find(x);
    int b = find(y);
    if (node_rank[a] >= node_rank[b]) {
        parent[b] = a;
        if (node_rank[a] == node_rank[b]) {
            node_rank[a]++;
        }
    } else {
        parent[a] = b;
    }
}

int main() {
    int n, m, a, b;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        parent.push_back(i);
        node_rank.push_back(1);
    }
    for (int i = 0; i < m; i++) {
        cin >> a >> b;
        if (find(a) != find(b)) {
            perform_union(a, b);
        } else {
            cout << "NO";
            return 0;
        }
    }
    cout << "YES";
    return 0;
}
