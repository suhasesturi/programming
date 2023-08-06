#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    while (true)
    {
        int a, b, c;
        cin >> a >> b >> c;
        if (a == 0 && b == 0 && c == 0) {
            break;
        }
        if ((b - a) == (c - b)) {
            cout << "AP " << c + (c - b) << "\n";
        } else {
            cout << "GP " << c * (c / b) << "\n";
        }
    }
    
    return 0;
}
