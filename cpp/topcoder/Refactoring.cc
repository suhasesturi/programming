#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Refactoring {
   public:
    int refactor(int n, int minf = 2) {
        int result = 0;
        for (int i = minf; i * i <= n; i++) {
            if (n % i == 0) {
                result++;
                result += refactor(n / i, i);
            }
        }
        return result;
    }
};

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    return 0;
}
