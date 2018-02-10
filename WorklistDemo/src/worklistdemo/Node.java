/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worklistdemo;

/**
 *
 * @author dani1covi
 */
public class Node {
  private String data; // Each node has a String...
  private Node link;   // ...and a link to the next Node

  /**
   * Node constructor.
   * @param theData the String to store in this Node
   * @param theLink a link to the next Node
   */
  public Node(String theData, Node theLink) {
    data = theData;
    link = theLink;
  }
  
  /**
   * Accessor for the String data stored in this Node.
   * @return our String item
   */
  public String getData() {
    return data;
  }
  
  /**
   * Accessor for the link to the next Node.
   * @return the next Node
   */
  public Node getLink() {
    return link;
  }
  
  public void setLink(Node n)
    {
         link = n;
    }    
}  

