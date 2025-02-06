package Assignment1;

import LinkedStack;

/*
 * Romin Patel
 * 3164066
 * Assignment-1
 * ACS-2947
 */
public class Calculator {
    private LinkedStack<Integer> undoStack;
    private LinkedStack<Integer> redoStack;
    private int result;

    public Calculator() {
        undoStack = new LinkedStack<>();
        redoStack = new LinkedStack<>();
    }

    public int getResult() {
        return result;
    }

    public void operations(char operator, int arithmetic) {
        undoStack.push(result);
        switch (operator) {
            case '+':
                result = result + arithmetic;
                break;
            case '-':
                result = result - arithmetic;
                break;
            case '*':
                result = result * arithmetic;
                break;
            case '/':
                if (arithmetic != 0) {
                    result = result / arithmetic;
                } else {
                    System.out.println("Invalid Math Operation");
                }
                break;
            default:
                System.out.println("Invalid operator");
        }

    }

    public void undoOperation() {
        if (!undoStack.isEmpty()) {
            redoStack.push(result);
            result = undoStack.pop();
            System.out.println("UNDO: " + result);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redoOperation() {
        if (!redoStack.isEmpty()) {
            undoStack.push(result);
            result = redoStack.top();
            redoStack.pop();
            System.out.println("REDO: " + result);
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}