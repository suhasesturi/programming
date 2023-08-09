#include <math.h>

#include <algorithm>
#include <deque>
#include <iostream>
#include <map>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;
    string temp;
    while (t-- > 0) {
        string a, b, c;
        cin >> a >> temp >> b >> temp >> c;
        if (a.find("machula") != -1) {
            cout << (stoi(c) - stoi(b)) << " + " << stoi(b) << " = " << stoi(c);
        } else if (b.find("machula") != -1) {
            cout << stoi(a) << " + " << (stoi(c) - stoi(a)) << " = " << stoi(c);
        } else {
            cout << stoi(a) << " + " << stoi(b) << " = " << (stoi(a) + stoi(b));
        }
        cout << "\n";
    }
    return 0;
}
