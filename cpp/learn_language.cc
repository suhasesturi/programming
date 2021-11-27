#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <vector>

using namespace std;

string values[10];

string (&fun1())[10] {
    return values;
}

decltype(values) &fun2() {
    return values;
}

int main() {
    string (&a)[10] = fun1();
    auto b = fun2();
    b = a;
    return 0;
}
