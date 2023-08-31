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

void counting_sort(vector<int>& p, vector<int>& c) {
    int n = p.size();
    vector<int> count(n, 0);
    for (auto x : c) {
        count[x]++;
    }
    vector<int> pos(n);
    pos[0] = 0;
    for (int i = 1; i < n; i++) {
        pos[i] = pos[i - 1] + count[i - 1];
    }
    vector<int> p_new(n);
    for (auto x : p) {
        int i = c[x];
        p_new[pos[i]] = x;
        pos[i]++;
    }
    p = p_new;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string s;
    cin >> s;
    s += '$';
    int n = s.length();
    vector<int> p(n), c(n);
    {
        // k = 0;
        vector<pair<char, int>> a(n);
        for (int i = 0; i < n; i++) a[i] = {s[i], i};
        sort(a.begin(), a.end());
        for (int i = 0; i < n; i++) p[i] = a[i].second;

        c[p[0]] = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].first == a[i - 1].first) {
                c[p[i]] = c[p[i - 1]];
            } else {
                c[p[i]] = c[p[i - 1]] + 1;
            }
        }
    }

    int k = 0;
    vector<int> c_new(n);
    while ((1 << k) < n) {
        for (int i = 0; i < n; i++) p[i] = (p[i] - (1 << k) + n) % n;
        counting_sort(p, c);

        c_new[p[0]] = 0;
        for (int i = 1; i < n; i++) {
            pair<int, int> prev = {c[p[i - 1]], c[(p[i - 1] + (1 << k)) % n]};
            pair<int, int> now = {c[p[i]], c[(p[i] + (1 << k)) % n]};
            if (prev == now) {
                c_new[p[i]] = c_new[p[i - 1]];
            } else {
                c_new[p[i]] = c_new[p[i - 1]] + 1;
            }
        }
        c = c_new;
        k++;
    }
    // for (int i = 0; i < n; i++) {
    //     cout << p[i] << " " << s.substr(p[i], n - p[i] - 1) << "\n";
    // }
    // cout << "\n";

    vector<int> lcp(n);
    k = 0;
    for (int i = 0; i < n - 1; i++) {
        int pi = c[i];
        int j = p[pi - 1];
        while (s[i + k] == s[j + k]) {
            k++;
        }
        lcp[pi] = k;
        k = max(k - 1, 0);
    }
    // for (int i = 0; i < n; i++) {
    //     cout << lcp[i] << " ";
    // }
    // cout << "\n";

    vector<long long> starting_with(26, 0);
    for (int i = 1; i < n; i++) {
        count += (n - p[i] - 1) - lcp[i];
    }
    cout << count << "\n";

    return 0;
}
