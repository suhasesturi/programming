#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

map<long long, long long> max_value;

long long get_max(long long n) {
    if (n <= 4) return n;
    if (max_value.find(n) != max_value.end()) {
        return max_value[n];
    }
    long long result = max(n, get_max(n / 2) + get_max(n / 3) + get_max(n / 4));
    max_value[n] = result;
    return result;
}

int main() {
    int n;
    while (cin >> n) {
        cout << get_max(n) << "\n";
    }
    return 0;
}
