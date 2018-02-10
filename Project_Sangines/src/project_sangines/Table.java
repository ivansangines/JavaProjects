package project_sangines;

public class Table {

    private Customer cos;
    private Queue queue;

    private Table(Customer c, Queue q) {
        this.cos = c;
        this.queue = q;
    }
    public Table(){
        
    }

    public Queue getQueue() {
        return queue;
    }

    public Customer getCos() {
        return cos;
    }

    public void setCos(Customer cos) {
        this.cos = cos;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public boolean isEmpty() {
        return getCos() == null;
    }

    public void doService() {
        if (getQueue() != null && getCos() != null) {
            getCos().setServiceTime(getCos().getServiceTime() - 1);
            if (getCos().getServiceTime() == 0) {
                System.out.println("Server finished with " + getCos().getName());
                setCos(queue.dequeue());
            }

        }
    }
    
    public String toString(){
        return getCos().toString();
    }

}
