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
public class Stack<T> {

    private int pointer;
    private int size;
    private T[] data;
    private final T EMPTY_STACK = null;

    public Stack() {
        this(50);
    }

    public Stack(int size) {
        this.pointer = 0;
        this.size = size;
        this.data = (T[]) new Object[this.size];
    }

    public boolean isEmpty() {
        return pointer == 0;

    }

    public boolean isFull() {
        return pointer == size;

    }

    public boolean push(T element) {
        if (!isFull()) {
            data[pointer++] = element;
            return true;
        }
        return false;
    }

    public T pop() {
        if (!isEmpty()) {
            T value = data[--pointer];
            return value;
        }
        return EMPTY_STACK;//With this number, the user will know that we have an error.

    }

    public T top() {
        if (!isEmpty()) {
            return this.data[pointer - 1];
        }
        return EMPTY_STACK;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {

        StringBuilder stackDisplay = new StringBuilder("");//Append==(+=) but more efficient
        if (!isEmpty()) {
            for (int i = pointer - 1; i >= 0; i--) {
                stackDisplay.append("| ").append(data[i]).append(" |").append("\n");

            }
        } else {
            stackDisplay.append("|  |");
        }
        return stackDisplay.toString();

    }
}

