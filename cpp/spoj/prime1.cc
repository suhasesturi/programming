#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<int> primes;

bool is_prime(int n) {
    if (n <= 1) {
        return false;
    }
    for (int i = 0;  i < primes.size() && primes[i] * primes[i] <= n; i++) {
        if (n % primes[i] == 0) {
            return false;
        }
    }
    return true;
}

void populate_primes(int till) {
    primes.push_back(2);
    for (int i = 3; i <= sqrt(till); i += 2) {
        if (is_prime(i)) {
            primes.push_back(i);
        }
    }
}

int main() {
    int t;
    cin >> t;

    populate_primes(1000000000);
    while (t-- > 0) {
        int n, m;
        cin >> n >> m;
        for (int i = n; i <= m; i++) {
            if (is_prime(i)) {
                cout << i << "\n";
            }
        }
        cout << "\n";
    }
    return 0;
}
