
package queue;


public class QueueClass <T>{
    private int front;
    private int size;
    private int rear;
    private T[] data;
    private final T EMPTY_QUEUE = null;
    
    public QueueClass(){ //why error if we don't have constructot(size)
        this(10);
    }
    public QueueClass(int size) {
        this.front = -1;
        this.rear=-1;
        this.size = size;
        this.data = (T[]) new Object[this.size];
    }
    
    public boolean isFull(){
        int r=rear;
        return front==(r+1)%size;
    }
    public boolean isEmpty(){
        int r=rear;
        return front==-1;
    }
    
    public boolean enqueue(T element){
        if(!isFull()){
            int r=(rear+1)%this.size;
            if(front==r){
            return false;
            }else if(front==-1){
                front=0;
                rear=0;
            }else{
                this.rear=r;
            }
            data[this.rear]=element;
            return true;
        }
        return false;
    }
    
    public T dequeue(){
        if(!isEmpty()){
            T valor=data[front];
            if(rear==front){
                front=-1;
                rear=-1;
            }else{
                front=(front+1)%size;
            }
            return valor;
        }
        return EMPTY_QUEUE;
    }
    public T front(){
        if(!isEmpty()){
            return this.data[front];
        }
        return null;
    }
    
       
    public String toString(){
         StringBuilder queueDisplay = new StringBuilder();
         queueDisplay.append("front= ").append(front).append(", rear= ").append(rear).append("; size= ").append(size).append("\n\nElements:\n\t[");
        if (!isEmpty()) {
            for (int i = front; i != rear; i = ((i + 1) % size)) {
                queueDisplay.append(data[i]).append(" | ");
            }
            queueDisplay.append(data[rear]);
        } 
            queueDisplay.append("]\n");
        return queueDisplay.toString();
    }
    
}
