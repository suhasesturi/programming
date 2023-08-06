#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        vector<short> result(1, 1);
        for (int i = 1; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < result.size(); j++) {
                carry += i * result[j];
                result[j] = carry % 10;
                carry /= 10;
            }
            while (carry > 0) {
                result.push_back(carry % 10);
                carry /= 10;
            }
        }
        for (int i = result.size() - 1; i >= 0; i--) {
            cout << result[i];
        }
        cout << "\n";
    }

    return 0;
}
