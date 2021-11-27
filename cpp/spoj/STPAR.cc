#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    int n, temp;
    cin >> n;
    while (n != 0) {
        stack<int> st;

        int i, j;
        for (i = 1, j = 1; i <= n && j <= n; j++) {
            while (!st.empty() && st.top() == i) {
                st.pop();
                i++;
            }
            cin >> temp;
            st.push(temp);
        }

        while (!st.empty() && st.top() == i) {
            st.pop();
            i++;
        }

        cout << (i == (n + 1) ? "yes" : "no") << "\n";
        cin >> n;
    }

    return 0;
}
