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
    stack<int> st;
    int maximum = 0, count = 0;
    for (int i = 0; i < s.length(); i++) {
        if (st.empty() || s[i] == '(') {
            st.push(i);
        } else {
            if (s[st.top()] == '(') {
                st.pop();
                int length = i - (st.empty() ? -1 : st.top());
                if (maximum < length) {
                    maximum = length;
                    count = 1;
                } else if (maximum == length) {
                    count++;
                }
            } else {
                st.push(i);
            }
        }
    }
    if (maximum == 0) {
        cout << "0 1" << "\n";
    } else {
        cout << maximum << " " << count << "\n";
    }

    return 0;
}
