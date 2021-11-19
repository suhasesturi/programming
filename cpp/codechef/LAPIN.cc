#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int chars[26] = {0};
        for (int i = 0; i < s.length() / 2; ++i) {
            chars[s[i] - 'a']++;
        }
        for (int i = s.length() / 2 + (s.length() % 2 == 0 ? 0 : 1);
             i < s.length(); ++i) {
            chars[s[i] - 'a']--;
        }
        bool flag = true;
        for (int i = 0; i < 26; ++i) {
            if (chars[i] != 0) {
                flag = false;
                break;
            }
        }
        cout << (flag ? "YES" : "NO") << "\n";
    }

    return 0;
}
