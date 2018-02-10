package stack_sangines;

public class StackClass<T> {
//    private static int top;
//    private T[] stack;
//    private int pointer;
//    private int size;
//    private final T EMPTY_STACK = null;
//
//        
//    public StackClass(){
//        this(10);
//    }
//    
//    public static void push(int a){
//        top++;
//        stack[top]=a;
//    }
//    
//    public static int pop(int b){
//        int var=stack[top];
//        top--;
//        return var;
//    }
//    public String toString(){
//    StringBuilder r = new StringBuilder();
//        for (int i = 0; i < stack.length; i++) {
//            r.append(stack[i]);
//
//        }
//        return r.toString();
//    }
//    
//}
//    private int top;

    private int top;
    private int size;
    private T[] stack;
    private final T EMPTY_STACK = null;

    public StackClass() {
        this(10);
    }

    public StackClass(int size) {
        this.top = -1;
        this.size = size;
        this.stack = (T[]) new Object[this.size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size;
    }

    public boolean push(T element) {
        if (!isFull()) {
            top++;
            stack[top] = element;
            System.out.println("Top:" + top);
            return true;
        }
        return false;
    }

    public T pop() {
        if (!isEmpty()) {
            T value = stack[top];
            top--;
            return value;
        }
        return EMPTY_STACK;//With this number, the user will know that we have an error.
    }
    
    public T findtop() {
        if (!isEmpty()) {
            return this.stack[top];
        }
        return EMPTY_STACK;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder stackDisplay = new StringBuilder("");
        if (!isEmpty()) {
            for (int i = top; i >= 0; i--) {
                stackDisplay.append("| ").append(stack[i]).append(" |").append("\n");

            }
        } else {
            stackDisplay.append("|  |");
        }
        return stackDisplay.toString();

    }
}
