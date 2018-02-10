package stack_sangines;

import java.util.Scanner;

public class Stack_Sangines {

    public static void main(String[] args) {
        StackClass<String> myStack = new <String> StackClass();

        menu(myStack);
    }

    public static void menu(StackClass myStack) {
        System.out.println("Enter the action that you want to do: " + "\n" + "1. Add elements" + "\n" + "2. Delete a position in the Stack" + "\n" + "3. Check if Stack is full" + "\n" + "4. Check if the Stack is empty" + "\n" + "5. Close Program ");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            int input = in.nextInt();
            switch (input) {
                case 1:
                    System.out.println("What do you want to add. Type tio if you want to exit this option");
                    String element = in.next();
                    if (element.equalsIgnoreCase("tio")) {
                        menu(myStack);
                    } else {
                        myStack.push(element);
                        myStack.display();
                    }
                    menu(myStack);
                    break;

                case 2:
                    if (myStack.isEmpty()) {
                        System.err.println("You cannot delete anything because your stack is already empty");
                    } else {
                        myStack.pop();
                        myStack.display();
                        menu(myStack);
                    }
                    break;
                case 3:
                    if (myStack.isFull() == false) {
                        System.out.println("Your stack is not full");
                        myStack.display();
                        menu(myStack);
                    }
                    System.out.println("Your stack is full, you cannot add anything.");
                    menu(myStack);
                    break;
                case 4:
                    if (myStack.isEmpty()) {
                        System.out.println("Your stack is empty, you cannot pop anything");
                        myStack.display();
                        menu(myStack);
                    }
                    System.out.println("Your Stack is not empty");
                    myStack.display();
                    menu(myStack);
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        } else {
            String bad = in.nextLine();
            System.out.println("Wrong input tio. Run the program again to start over :)");
        }
    }
}
