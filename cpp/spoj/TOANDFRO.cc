#include <math.h>

#include <algorithm>
#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    int columns;
    while (true) {
        cin >> columns;
        if (columns == 0) break;
        string text;
        cin >> text;
        string output = "";
        for (int column = 0; column < columns; column++) {
            for (int row = 0; row < text.length() / columns; row++) {
                if (row % 2 == 0) {
                    output.push_back(text[row * columns + column]);
                } else {
                    output.push_back(
                        text[row * columns + columns - column - 1]);
                }
            }
        }
        cout << output << "\n";
    }

    return 0;
}
