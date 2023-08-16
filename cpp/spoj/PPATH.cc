#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

vector<int> primes;

bool is_prime(int n) {
    for (int i = 0; i < primes.size() && primes[i] * primes[i] <= n; i++) {
        if (n % primes[i] == 0) {
            return false;
        }
    }
    return true;
}

void populate_primes(int till) {
    primes.push_back(2);
    for (int i = 3; i <= till; i += 2) {
        if (is_prime(i)) {
            primes.push_back(i);
        }
    }
}

class Graph {
   public:
    Graph() { edges.resize(9999, vector<int>()); }

    void add_edge(int a, int b) {
        edges[a].push_back(b);
        edges[b].push_back(a);
    }

    int bfs(int start, int end, vector<int>& distance) {
        if (start == end) {
            return 0;
        }
        distance[start] = 0;
        deque<int> nodes;
        nodes.push_back(start);

        while (!nodes.empty()) {
            int u = nodes.front();
            nodes.pop_front();

            for (int v : edges[u]) {
                if (v == end) {
                    return distance[u] + 1;
                }
                if (distance[v] == -1) {
                    distance[v] = distance[u] + 1;
                    nodes.push_back(v);
                }
            }
        }
        return -1;
    }

   private:
    vector<vector<int>> edges;
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    populate_primes(9999);
    int start = 0;
    for (int i = 0; i < primes.size(); i++) {
        if (primes[i] > 1000) {
            start = i;
            break;
        }
    }

    Graph graph;

    for (int i = start; i < primes.size(); i++) {
        for (int j = i + 1; j < primes.size(); j++) {
            int count = 0, first = primes[i], second = primes[j];
            while (first > 0) {
                if ((first % 10) != (second % 10)) {
                    count++;
                }
                first /= 10;
                second /= 10;
            }
            if (count == 1) {
                graph.add_edge(primes[i], primes[j]);
            }
        }
    }

    int t;
    cin >> t;
    vector<int> distance(9999, -1);
    while (t-- > 0) {
        int start, end;
        cin >> start >> end;
        int result = graph.bfs(start, end, distance);
        if (result == -1) {
            cout << "Impossible\n";
        } else {
            cout << result << "\n";
        }
        fill(distance.begin(), distance.end(), -1);
    }
    return 0;
}
