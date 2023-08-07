#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <stack>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, current, i = 1;
    while (true) {
        cin >> n;
        if (n == 0) break;
        stack<int> st;
        i = 1;
        while (n-- > 0) {
            cin >> current;
            while (!st.empty() && st.top() == i) {
                st.pop();
                i++;
            }
            if (current == i) {
                i++;
            } else {
                st.push(current);
            }
        }
        while (!st.empty() && st.top() == i) {
            st.pop();
            i++;
        }
        cout << (st.empty() ? "yes" : "no") << "\n";
        // cout << i << " " << st.size() << " \n" ;
    }
    return 0;
}
