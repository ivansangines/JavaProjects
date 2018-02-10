/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author ivans_000
 */
public class Tools {

    public int getResult(String input) throws PostFix {
        String[] tokArr = input.split(" ");
        Stack<Integer> OperandStack = new <Integer> Stack();
        for (int i = 0; i < tokArr.length; i++) {
            if (tokArr[i].charAt(0) == '+' || tokArr[i].charAt(0) == '-' || tokArr[i].charAt(0) == '*' || tokArr[i].charAt(0) == '/') {
                int operand2 = OperandStack.pop();
                int operand1 = OperandStack.pop();
                if (tokArr[i].charAt(0) == '+') {
                    int result = operand1 + operand2;
                    OperandStack.push(result);

                } else if (tokArr[i].charAt(0) == '-') {
                    int result = operand1 - operand2;
                    OperandStack.push(result);

                } else if (tokArr[i].charAt(0) == '/') {
                    int result = operand1 / operand2;
                    OperandStack.push(result);
                } else if (tokArr[i].charAt(0) == '*') {
                    int result = operand1 * operand2;
                    OperandStack.push(result);
                }
            } else {
                OperandStack.push(Integer.parseInt(tokArr[i]));
            }

        }
        int result = OperandStack.top();
        return result;
    }

    public String infixToPostTIO(String in) throws PostFix {
        String[] myArray = in.split(" ");
        StringBuilder output = new StringBuilder();
        Stack<String> myStack = new Stack<String>();

        for (int i = 0; i < myArray.length; i++) {

            String operator = null;
            try {
                int value = Integer.parseInt(myArray[i]);

            } catch (Exception e) {
                operator = myArray[i];
            }
            if (operator == null) {// si es un numero
                output.append(myArray[i] + " ");
            } else if (operator.equalsIgnoreCase("(")) {
                myStack.push(operator);
            } else if (operator.equalsIgnoreCase("+") || operator.equalsIgnoreCase("-") || operator.equalsIgnoreCase("*") || operator.equalsIgnoreCase("/")) {
                if (!myStack.isEmpty()) {
                    System.out.println("operator = " + operator);
                    System.out.println("operator = " + myStack.top());
                    while (myStack.top() != null && getPrecednce(myStack.top().charAt(0)) >= getPrecednce(operator.charAt(0))) {
                        output.append(myStack.pop() + " ");
                        if (myStack.top() == null) {
                            break;
                        }

                    }
                }
                myStack.push(operator);
                
            } else if (operator.equalsIgnoreCase(")")) {
                while (!myStack.isEmpty()) {
                    if (!myStack.top().equalsIgnoreCase("(")) {
                        output.append(myStack.pop() + " ");
                    } else {
                        myStack.pop();
                        break;
                    }
                }
            }

        }
        while (!myStack.isEmpty()) {
            output.append(myStack.pop() + " ");
        }
        return output.toString();

    }

    public int getPrecednce(char op) {
        switch (op) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '(':
                return 0;
            default:
                return -1;
        }
    }

}

