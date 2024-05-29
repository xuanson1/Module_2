import File.MyStack;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import java.util.Stack;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        stack.pop();
        System.out.println("Top items of stack " + stack.pop());

        System.out.println("Total items of stack " + stack.size());
    }
}