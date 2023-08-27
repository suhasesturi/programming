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

class Trie {
   public:
    bool is_leaf;
    int count;
    Trie* character[10];

    Trie() {
        this->is_leaf = false;
        this->count = 0;
        for (int i = 0; i < 10; i++) {
            this->character[i] = nullptr;
        }
    }

    void insert(string& s) {
        Trie* current = this;
        for (int i = 0; i < s.length(); i++) {
            if (current->character[s[i] - '0'] == nullptr) {
                current->character[s[i] - '0'] = new Trie();
            }
            current = current->character[s[i] - '0'];
            (current->count)++;
        }
        current->is_leaf = true;
    }

    // return true if s is a prefix
    bool check(string& s) {
        Trie* current = this;
        for (int i = 0; i < s.length(); i++) {
            if (current->character[s[i] - '0'] == nullptr) {
                return true;
            }
            current = current->character[s[i] - '0'];
        }
        return current->count > 1;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        vector<string> numbers(n);
        Trie trie;
        for (int i = 0; i < n; i++) {
            cin >> numbers[i];
            trie.insert(numbers[i]);
        }
        bool flag = true;
        for (int i = 0; i < n; i++) {
            if (trie.check(numbers[i])) {
                flag = false;
                break;
            }
        }
        cout << (flag ? "YES" : "NO") << "\n";
    }
    return 0;
}
