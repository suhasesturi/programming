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

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long n, k;
    cin >> n >> k;
    map<long long, int> numbers;
    int temp;
    for (int i = 0; i < n; i++) {
        cin >> temp;
        if (numbers.count(temp) == 0) {
            numbers[temp] = 0;
        }
        numbers[temp]++;
    }
    
    long long result = 0;
    for (auto entry : numbers) {
        if (numbers.count(entry.first + k) != 0) {
            result += entry.second * numbers[entry.first + k];
        }
    }
    cout << result << "\n";

    return 0;
}
