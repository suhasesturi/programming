#include <math.h>

#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    cin >> n;
    int result = 0;
    for (int i = 1; i <= sqrt(n); i++) {
        result += n / i - (i - 1);
    }
    cout << result << "\n";
    return 0;
}
