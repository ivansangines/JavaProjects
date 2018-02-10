package queue;

import java.util.Scanner;

public class Queue {

    public static void main(String[] args) {
        QueueClass<String> myQueue = new <String> QueueClass();

        menu(myQueue);
    }

    public static void menu(QueueClass myQueue) {
        System.out.println("Enter the action that you want to do: " + "\n" + "1. Add elements" + "\n" + "2. Delete a position in the Queue" + "\n" + "3. Print Font"+ "\n"+ "4. Print Queue"+ "\n"+ "5. Close Program ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            switch (in.nextInt()) {
                case 1:
                    System.out.println("What do you want to add. Type tio if you want to exit this option");
                    String element = in.next();
                    if (element.equalsIgnoreCase("tio")) {
                        menu(myQueue);
                    } else {
                        myQueue.enqueue(element);
                    }
                    menu(myQueue);
                    break;

                case 2:
                    if (myQueue.isEmpty()) {
                        System.err.println("You cannot delete anything because your queue is empty");
                    } else {
                        myQueue.dequeue();
                        menu(myQueue);
                    }
                    break;
                case 3:
                    System.out.println("Element at the front of the Queue: ");
                    Object num=myQueue.front();
                    System.out.println("Front: "+num);
                    menu(myQueue);
                    break;
                case 4:
                    System.out.println("Values on the Queue: ");
                    System.out.println(myQueue);
                    menu(myQueue);
                    break;
                case 5:
                    System.out.println("Closing program");
                    break;
            }
        } else {
            String bad = in.nextLine();
            System.out.println("Wrong input tio. Run the program again to start over :)");
        }
    }
}

