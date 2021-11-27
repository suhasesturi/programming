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
        string input;
        cin >> input;
        stack<char> st;
        char first, second, op;
        for (char ch : input) {
            if (ch == '(') {
                continue;
            }
            if (ch == ')') {
                cout << st.top();
                st.pop();
            } else if (ch >= 'a' && ch <= 'z') {
                cout << ch;
            } else {
                st.push(ch);
            }
        }
        cout << "\n";
    }

    return 0;
}
