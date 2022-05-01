#include <algorithm>
#include <cmath>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class PrimePolynom {
   private:
    bool is_prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

   public:
    int reveal(int A, int B, int C) {
        for (int m = 0; true; m++) {
            if (!is_prime(A * m * m + B * m + C)) {
                return m;
            }
        }
    }
};

int main() {
    return 0;
}
