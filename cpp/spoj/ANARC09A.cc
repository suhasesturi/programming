#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    for (int i = 1; true; ++i) {
        string s;
        cin >> s;
        if (s[0] == '-') {
            break;
        }
        int count = 0;
        int current = 0;
        for (char ch : s) {
            if (ch == '{') {
                current++;
            } else if (ch == '}' && current == 0) {
                count++;
                current = 1;
            } else if (ch == '}') {
                current--;
            }
        }
        cout << i << ". " << count + current / 2 << "\n";
    }

    return 0;
}
