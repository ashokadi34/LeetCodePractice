package leetCodeProblems;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class MyStack {
    private Queue<Integer> q;

    public MyStack() {
        q = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
    
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner sc = new Scanner(System.in);
        
        // Test the example
        stack.push(1);
        stack.push(2);
        System.out.println("top(): " + stack.top());     // 2
        System.out.println("pop(): " + stack.pop());     // 2
        System.out.println("empty(): " + stack.empty()); // false
        
        // Interactive testing
        System.out.println("\nEnter commands (push x, pop, top, empty, quit):");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("quit")) break;
            
            if (input.startsWith("push ")) {
                int x = Integer.parseInt(input.substring(5));
                stack.push(x);
                System.out.println("Pushed " + x);
            } else if (input.equals("pop")) {
                System.out.println("pop(): " + stack.pop());
            } else if (input.equals("top")) {
                System.out.println("top(): " + stack.top());
            } else if (input.equals("empty")) {
                System.out.println("empty(): " + stack.empty());
            }
        }
        sc.close();
    }
}

