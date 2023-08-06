#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n, result = 0;
        cin >> n;
        while (n > 0)
        {
            result += n / 5;
            n /= 5;
        }
        cout << result << "\n";
    }

    return 0;
}
