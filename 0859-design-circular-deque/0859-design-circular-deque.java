class MyCircularDeque {
    int front = -1;
    int rear = -1;
    int size;
    int[] cQ;

    public MyCircularDeque(int k) {
        cQ = new int[k];
        size = k;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
            cQ[front] = value;
        } else if (front == 0) {
            front = size - 1;
            cQ[front] = value;
        } else {
            front--;
            cQ[front] = value;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        if (isEmpty()) {
            front = 0;
            rear = 0;
            cQ[rear] = value;
        } else if (rear == size - 1) {
            rear = 0;
            cQ[rear] = value;
        } else {
            rear++;
            cQ[rear] = value;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front++;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;
        } else {
            rear--;
        }
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return cQ[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return cQ[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == (rear + 1) % size;
    }
}