#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int n;
    while (true) {
        cin >> n;
        if (n == 0) {
            break;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += (n - i) * (n - i);
        }
        cout << result << endl;
    }
    return 0;
}
