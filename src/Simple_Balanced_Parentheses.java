import java.util.Scanner;

// Stack implementation using array
class Stack {
    private char[] stack;
    private int top;

    // Constructor
    Stack(int size) {
        stack = new char[size];
        top = -1;
    }

    // Push method
    void push(char ch) {
        stack[++top] = ch;
    }

    // Pop method
    char pop() {
        return stack[top--];
    }

    // Peek method
    char peek() {
        return stack[top];
    }

    // Check if empty
    boolean isEmpty() {
        return top == -1;
    }

    // Size method
    int size() {
        return top + 1;
    }
}

public class Simple_Balanced_Parentheses {

    public static boolean isBalanced(String expression) {

        Stack stack = new Stack(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // closing without opening
                }
                stack.pop();
            }
        }

        // If stack empty, expression is balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Arithmetic Expression:");
        String expression = sc.nextLine();

        boolean result = isBalanced(expression);

        if(result) {
            System.out.println("The Balance of " + expression + " is balanced.");
        }else{
            System.out.println("The Balance of " + expression + " is not balanced.");
        }

        sc.close();
    }
}
