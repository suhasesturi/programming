#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    stack<char> st;
    for (char ch : s) {
        if (st.empty() || st.top() != ch) {
            st.push(ch);
        } else {
            st.pop();
        }
    }
    cout << (st.empty() ? "Yes" : "No") << "\n";

    return 0;
}
