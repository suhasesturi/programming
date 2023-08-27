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

vector<int> primes;
int MAX = 100000001;
vector<int> is_prime(MAX, 0);

void populate_primes() {
    primes.push_back(2);
    cout << "2\n";
    is_prime[0] = is_prime[1] = 1;

    for (int i = 3; i < MAX; i += 2) {
        if (is_prime[i] == 0) {
            primes.push_back(i);
            if (primes.size() % 100 == 1) {
                cout << *(primes.end() - 1) << "\n";
            }
            for (long long j = (long long)i * i; j < MAX; j += 2 * i) {
                is_prime[j] = 1;
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    populate_primes();
    return 0;
}
