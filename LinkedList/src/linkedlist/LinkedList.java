package linkedlist;

import java.util.Scanner;

public class LinkedList {

    public static void main(String[] args) {
        ListClass myList = new ListClass();
        menu(myList);
    }

    public static void menu(ListClass list) {
        System.out.println("Please enter the action you want to do:\n1. Add an element to the list \n2. Delete an element to the list\n3.Print\n4.Quit\n\n");
        System.out.print("Enter choice: ");
        Scanner in = new Scanner(System.in);

        if (in.hasNextInt()) {
            int userChoice = in.nextInt();
            if (userChoice >= 1 && userChoice <= 4) {
                switch (userChoice) {
                    case 1:

                        System.out.print("\nEnter the element that you want to add: ");
                        String element = in.next();

                        list.insert(element);
                        System.out.println("The element " + element + " has been added.\n");
                        menu(list);
                        break;
                    case 2:
                        if (list.getHead() != null) {
                            System.out.print("\nEnter the element that you want to delete ");
                            element = in.next();
                            if (list.delete(element) != false) {
                                System.out.println("The element " + element + " has been deleted.\n");
                            } else {
                                System.out.println("Element not found.");
                            }
                        } else {
                            System.out.println("The list is empty");
                        }
                        menu(list);
                        break;
                    case 3:
                        System.out.println("\nPrinting...");

                        list.display();
                        menu(list);
                        break;

                    case 4:
                        System.out.println("\nEnding Program Now...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }

            } else {
                System.err.println("Please enter a number between 1 and 4");
                menu(list);
            }
        } else {
            String bad = in.nextLine();
            System.out.println("Wrong input tio. Please enter a number between 1 and 4 :)");
            menu(list);
        }
    }
}
