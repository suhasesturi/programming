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

void radix_sort(vector<pair<pair<int, int>, int>>& a) {
    {
        int n = a.size();
        vector<pair<pair<int, int>, int>> a_new(n);
        vector<int> count(n, 0);
        for (auto x : a) {
            count[x.first.second]++;
        }
        vector<int> pos(n);
        pos[0] = 0;
        for (int i = 1; i < n; i++) {
            pos[i] = pos[i - 1] + count[i - 1];
        }
        for (auto x : a) {
            int i = x.first.second;
            a_new[pos[i]] = x;
            pos[i]++;
        }
        a = a_new;
    }
    {
        int n = a.size();
        vector<pair<pair<int, int>, int>> a_new(n);
        vector<int> count(n, 0);
        for (auto x : a) {
            count[x.first.first]++;
        }
        vector<int> pos(n);
        pos[0] = 0;
        for (int i = 1; i < n; i++) {
            pos[i] = pos[i - 1] + count[i - 1];
        }
        for (auto x : a) {
            int i = x.first.first;
            a_new[pos[i]] = x;
            pos[i]++;
        }
        a = a_new;
    }
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
    vector<pair<pair<int, int>, int>> a(n);
    while ((1 << k) < n) {
        for (int i = 0; i < n; i++) a[i] = {{c[i], c[(i + (1 << k)) % n]}, i};
        radix_sort(a);
        for (int i = 0; i < n; i++) p[i] = a[i].second;

        c[p[0]] = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].first == a[i - 1].first) {
                c[p[i]] = c[p[i - 1]];
            } else {
                c[p[i]] = c[p[i - 1]] + 1;
            }
        }
        k++;
    }
    for (int i = 0; i < n; i++) {
        cout << p[i] << " ";
    }
    cout << "\n";

    return 0;
}
