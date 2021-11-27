#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int count = 0;
        stack<char> st;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s[i];
            if (ch == '<') {
                st.push(ch);
            } else {
                if (!st.empty() && st.top() == '<') {
                    st.pop();
                } else {
                    break;
                }
            }
            if (st.empty()) {
                count = i + 1;
            }
        }
        cout << count << "\n";
    }

    return 0;
}
