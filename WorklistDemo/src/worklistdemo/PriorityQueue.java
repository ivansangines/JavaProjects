/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worklistdemo;

public class PriorityQueue implements Worklist {

    private Node top = null;
    private Node tail = null;
    public int counter = 0;

    @Override
    public void add(String item) {
        Node n = new Node(item, null);//Set new info to a new node n
        if (tail == null) {//just gets in first time
            top = n;// first top and tail are same
            tail = n;
        } else {

            Node current = top;
            Node prev = top;
            while (hasMore()) {
                if (item.compareTo(top.getData()) <= 0) {
                    n.setLink(top);
                    top = n;
                    break;
                } else if (item.compareTo(current.getData()) <= 0) {
                    prev.setLink(n);
                    n.setLink(current);
                    break;
                } else if (item.compareTo(current.getData()) > 0) {
                    prev = current;
                    current = current.getLink();
                    if(current==null){
                        prev.setLink(n);
                        break;
                    }

                }
            }
        }
        counter++;
    }

    @Override
    public boolean hasMore() {
        return (top != null);

    }

    @Override
    public String remove() {
        if (!hasMore()) {//is empty
            System.err.println("Queue is empty!");
        }
        Node n = top;//first element
        top = n.getLink();//reference 2nd element
        if (top == null) {//just 1 element
            tail = null;
        }
        counter--;//dicrease size
        return n.getData();// return 2nd element

    }

}
