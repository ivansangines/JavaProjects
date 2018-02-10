
package linkedlist;


public class Node<T> {
    private T data;
    private Node next;

    public Node(T data) {
        this.data=data;
        this.next=next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }

   
}