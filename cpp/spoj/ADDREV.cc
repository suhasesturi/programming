#include <iostream>

using namespace std;

int reverse(int a) {
    int result = 0;
    while (a > 0) {
        result = result * 10 + a % 10;
        a = a / 10;
    }
    return result;
}

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int a, b;
        cin >> a >> b;
        cout << reverse(reverse(a) + reverse(b)) << "\n";
    }

    return 0;
}
