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
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   public:
    int lengthOfLongestSubstring(string s) {
        map<char, int> visited;
        int ans = 0, start = 0;
        for (int i = 0; i < s.size(); i++) {
            if (visited.find(s[i]) != visited.end() && visited[s[i]] >= start) {
                ans = max(ans, i - start);
                start = visited[s[i]] + 1;
            }
            visited[s[i]] = i;
        }
        ans = max(ans, (int)s.size() - start);
        return ans;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cout << (new Solution())->lengthOfLongestSubstring("abcabcbb") << "\n";
    cout << (new Solution())->lengthOfLongestSubstring("abba") << "\n";

    return 0;
}
