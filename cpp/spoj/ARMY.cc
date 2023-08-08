#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n, m, temp;
        cin >> n >> m;
        int n_max = 0;
        int m_max = 0;
        for (int i = 0; i < n; i++) {
            cin >> temp;
            n_max = max(n_max, temp);
        }
        for (int i = 0; i < m; i++) {
            cin >> temp;
            m_max = max(m_max, temp);
        }
        cout << (n_max >= m_max ? "Godzilla" : "MechaGodzilla") << "\n";
    }
    return 0;
}
