/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worklistdemo;


public class Queue implements Worklist {

   private Node top=null;
   private Node tail=null;
   public int counter=0;

    @Override
    public void add(String item) {
        
    Node n=new Node (item,null);//Set new info to a new node n
    if(tail==null){//just gets in first time
        top=n;// first top and tail are same
        tail=n;
    }
    else{//else times, we have elements
        tail.setLink(n);//sets previous link to new element
        tail=tail.getLink();//link is going to be new element, thus new tail.
    } 
    counter++;
    }

    @Override
    public boolean hasMore() {
        return (top!=null);
    }

    @Override
    public String remove() {
        if(!hasMore()){//is empty
            System.err.println("Queue is empty!");
        }
        Node n=top;//first element
        top=n.getLink();//reference 2nd element
        if(top==null){//just 1 element
            tail=null;
        }
         counter--;//dicrease size
         return n.getData();// return 2nd element
            
      
    }

   
}

