package leetCodeProblems;

import java.util.Stack;
import java.util.Scanner;

public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }
    
    public void push(int x) {
        in.push(x);
    }
    
    public int pop() {
        peek();
        return out.pop();
    }
    
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }
    
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println(q.peek());  // 1
        System.out.println(q.pop());   // 1
        System.out.println(q.empty()); // false
        
        // Interactive mode
        Scanner sc = new Scanner(System.in);
        System.out.println("\nCommands: push <num>, pop, peek, empty, quit");
        while(true) {
            System.out.print("> ");
            String[] cmd = sc.nextLine().trim().split(" ");
            if(cmd[0].equals("quit")) break;
            if(cmd[0].equals("push") && cmd.length > 1) {
                q.push(Integer.parseInt(cmd[1]));
                System.out.println("pushed " + cmd[1]);
            } else if(cmd[0].equals("pop")) {
                if(!q.empty()) System.out.println("pop: " + q.pop());
                else System.out.println("empty");
            } else if(cmd[0].equals("peek")) {
                if(!q.empty()) System.out.println("peek: " + q.peek());
                else System.out.println("empty");
            } else if(cmd[0].equals("empty")) {
                System.out.println("empty: " + q.empty());
            }
        }
        sc.close();
    }
}


