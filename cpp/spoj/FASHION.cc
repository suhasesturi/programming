#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    int t;
    cin >> t;
    while (t-- > 0) {
        int n;
        cin >> n;
        vector<int> male(n);
        vector<int> female(n);
        for (int i = 0; i < n; i++) {
            cin >> male[i];
        }
        for (int i = 0; i < n; i++) {
            cin >> female[i];
        }
        sort(male.begin(), male.end());
        sort(female.begin(), female.end());
        long long sum = 0;
        for (size_t i = 0; i < n; i++) {
            sum += male[i] * female[i];
        }
        cout << sum << "\n";
    }
    return 0;
}
