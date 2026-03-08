package leetCodeProblems;

import java.util.*;

class simplifyPath {
    public String simplifyPaths(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) continue;
            if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }
        
        StringBuilder sb = new StringBuilder("/");
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i));
            if (i > 0) sb.append("/");
        }
        
        return sb.length() == 1 ? "/" : sb.toString();
    }
    
    // Test locally
    public static void main(String[] args) {
    	simplifyPath sol = new simplifyPath();
        String[] tests = {
            "/home/",
            "/home//foo/",
            "/home/user/Documents/../Pictures",
            "/../",
            "/.../a/../b/c/../d/./"
        };
        
        for (String test : tests) {
            System.out.println(test + " → " + sol.simplifyPaths(test));
        }
    }
}
