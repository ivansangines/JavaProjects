
public class Queue {

    int front;
    int rear;
    int data[];
    int size = 5;

    public Queue() {
        data = (new int[size]);
        front = 0;
        rear = 0;
    }

    public Queue(int size) {
        data = (new int[size]);
        this.size = size;
        front = 0;
        rear = 0;
    }

    public void enqueue(int n) throws Exception {
        try {
            if (((rear + 1) % size) == front) { // checks if queue is full
                throw new Exception("Queue is full. Cannot enqueue.");
            }
            data[(rear++) % size] = n;
        } catch (Exception ee) {
            throw ee;
        }
    }

    public int dequeue() throws Exception {
        try {
            if (front == rear) // queue is empty
            {
                throw new Exception("Queue is empty. Cannot dequeue.");
            }
            return data[(front++) % size];
        } catch (Exception e) {
            throw e;
        }
    }

    public String toString() {
        String res = "";
        int tempFront = front;
        while (tempFront != (rear % size)) {
            res += data[tempFront] + " ";
            tempFront = (tempFront + 1) % size;
        }
        return res;
    }

}
