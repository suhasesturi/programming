#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    string s;
    cin >> s;
    stack<char> st;
    int letters[26];
    for (int i = 0; i < 26; ++i) {
        letters[i] = -1;
    }
    for (int i = 0; i < s.length(); ++i) {
        letters[s[i] - 'a'] = i;
    }
    int index = 0, u = 0;
    for (int i = 0; i < 26; ++i) {
        while (!st.empty() && st.top() <= (char)(i + 'a')) {
            s[u++] = st.top();
            st.pop();
        }
        for (; index <= letters[i]; ++index) {
            if (s[index] == (char)(i + 'a')) {
                s[u++] = (char)(i + 'a');
            } else {
                st.push(s[index]);
            }
        }
    }
    while (!st.empty()) {
        s[u++] = st.top();
        st.pop();
    }
    cout << s << "\n";

    return 0;
}
