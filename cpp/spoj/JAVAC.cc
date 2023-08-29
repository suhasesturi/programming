#define _USE_MATH_DEFINES

#include <algorithm>
#include <cmath>
#include <cstdint>
#include <deque>
#include <functional>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>

using namespace std;

string c_to_java(string& s) {
    string result = "";
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '_') {
            result += (char)('A' + (s[i + 1] - 'a'));
            i++;
        } else {
            result += s[i];
        }
    }

    return result;
}

string java_to_c(string& s) {
    string result = "";
    for (int i = 0; i < s.length(); i++) {
        if (s[i] >= 'A' && s[i] <= 'Z') {
            result += '_';
            result += (char)('a' + (s[i] - 'A'));
        } else {
            result += s[i];
        }
    }

    return result;
}

bool is_c(string& s) {
    if (s[0] == '_' || s[s.length() - 1] == '_') return false;

    for (int i = 0; i < s.length(); i++) {
        if (s[i] >= 'A' && s[i] <= 'Z') return false;
        if (s[i] == '_' && i < s.length() - 1) {
            if (s[i + 1] == '_') return false;
        }
    }
    return true;
}

bool is_java(string& s) {
    if (s[0] >= 'A' && s[0] <= 'Z') return false;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '_') return false;
    }
    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string s;
    while (cin >> s) {
        bool c = is_c(s);
        bool java = is_java(s);
        if (!c && !java) {
            cout << "Error!\n";
        } else if (c) {
            cout << c_to_java(s) << "\n";
        } else if (java) {
            cout << java_to_c(s) << "\n";
        }
    }
}
