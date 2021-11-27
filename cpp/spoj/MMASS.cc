#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int weight_of_molecule(string molecule) {
    stack<int> st;
    for (char ch : molecule) {
        if (ch == 'H') {
            st.push(1);
        } else if (ch == 'C') {
            st.push(12);
        } else if (ch == 'O') {
            st.push(16);
        } else if (ch == '(') {
            st.push(0);
        } else if (ch == ')') {
            int weight = 0;
            while (st.top() != 0) {
                weight += st.top();
                st.pop();
            }
            st.pop();
            st.push(weight);
        } else {
            int temp = st.top();
            st.pop();
            st.push(temp * (ch - '0'));
        }
    }
    int weight = 0;
    while (!st.empty()) {
        weight += st.top();
        st.pop();
    }
    return weight;
}

int main() {
    string molecule;
    cin >> molecule;

    cout << weight_of_molecule(molecule);

    return 0;
}
