package project_sangines;

public class Queue {

    private int front;
    private int size;
    private int rear;
    private Customer[] data;
    private int elements;

    public Queue() { 
        this(4);
    }

    public Queue(int size) {
        this.front = -1;
        this.rear = -1;
        this.size = size;
        this.data = new Customer[this.size];
        elements=0;
    }

    public boolean isFull() {
        int r = rear;
        return front == (r + 1) % size;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean enqueue(Customer element) {
        if (!isFull()) {
            int r = (rear + 1) % this.size;
            if (front == r) {
                return false;
            } else if (front == -1) {
                front = 0;
                rear = 0;
            } else {
                this.rear = r;
            }
            elements++;
            data[this.rear] = element;
            return true;
        }
        return false;
    }

    public Customer dequeue() {
        Customer valor = null;
        if (!isEmpty()) {
             valor = data[front];
            if (rear == front) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;

            }
            elements--;
        }
        return valor;
    }

    public Customer front() {
        if (!isEmpty()) {
            return this.data[front];
        }
        return null;
    }
    public int getElements(){
        return elements;
    }

}
