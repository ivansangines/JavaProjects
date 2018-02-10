package linkedlist;

public class ListClass<T> {

    private Node<T> head;
    private int counter;
    private boolean found = false;

    public ListClass() {
        head = null;

    }

    public <T> boolean insert(T element) {
        Node n = new <T> Node(element);
        if (head == null) { //list empty
            head = n;

        } else {
            Node last = getLastNode();
            last.setNext(n);

        }
        counter++;
        return true;
    }

    public Node getLastNode() {
        Node curr = head;
        while (curr != null && curr.getNext() != null) {
            curr = curr.getNext();
        }
        return curr;
    }

    public Node getHead() {
        return head;
    }

    @Override
    public String toString() {
        return "LinkedList{" + "head=" + head + '}';
    }

    public boolean delete(T element) {
        if (head != null) {//list is not empty
            Node prev = find(element);
            if (found) {
                if (prev == null) {
                    head = head.getNext();
                } else {
                    if (prev.getNext().getNext() == null) {
                        prev.setNext(null);
                    } else {
                        prev.setNext(prev.getNext().getNext());
                    }
                }
                counter--;
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public Node find(T element) {
        found = false;
        Node prev = null;
        Node current = head;
        while (current != null && !current.getData().equals(element)) {
            prev = current;
            current = current.getNext();
        }

        if (current != null) {
            if (current.getData().equals(element)) {
                found = true;
            }
        }

        return prev;
    }

    public <T> void display() {
        Node actual = head;
        while (actual != null && actual.getNext() != null) {
            System.out.print(actual.getData() + "-->");
            actual = actual.getNext();
        }
        if (actual != null) {
            System.out.println(actual.getData() + " -->NULL");

        } else {
            System.out.println("NULL");
        }
        System.out.println("Number of elements " + counter + "\n");
    }
}
