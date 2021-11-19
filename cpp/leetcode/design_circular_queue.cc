#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

class MyCircularQueue {
   private:
    vector<int> queue;
    int size, head, tail;

   public:
    MyCircularQueue(int k) {
        size = k;
        queue.resize(k);
        head = -1;
        tail = -1;
    }

    bool enQueue(int value) {
        if (isFull()) return false;
        tail++;
        queue[tail % size] = value;
        return true;
    }

    bool deQueue() {
        if (isEmpty()) return false;
        head++;
        return true;
    }

    int Front() {
        if (isEmpty()) return -1;
        return queue[(head + 1) % size];
    }

    int Rear() {
        if (isEmpty()) return -1;
        return queue[tail % size];
    }

    bool isEmpty() { return tail == head; }

    bool isFull() { return (tail - head) == size; }
};
