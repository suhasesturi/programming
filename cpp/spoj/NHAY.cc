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

vector<int> prefix(string& pattern) {
    vector<int> pfn(pattern.length());
    pfn[0] = -1;
    int k = -1;
    for (int q = 1; q < pattern.length(); q++) {
        while (k > -1 && pattern[k + 1] != pattern[q]) {
            k = pfn[k];
        }
        if (pattern[k + 1] == pattern[q]) {
            k++;
        }
        pfn[q] = k;
    }
    return pfn;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    while (cin >> n) {
        string pattern, text;
        cin >> pattern >> text;
        vector<int> pfn = prefix(pattern);
        int q = -1;
        for (int i = 0; i < text.length(); i++) {
            while (q > -1 && pattern[q + 1] != text[i]) {
                q = pfn[q];
            }
            if (pattern[q + 1] == text[i]) {
                q++;
            }
            if (q == pattern.length() - 1) {
                cout << i - pattern.length() + 1 << "\n";
            }
        }
        cout << "\n";
    }
}
