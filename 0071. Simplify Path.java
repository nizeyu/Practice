class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(".") || strs[i].length() == 0 ) {
                continue;
            } else if (!strs[i].equals("..")) {
                stack.push(strs[i]);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        
        Stack<String> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!temp.isEmpty()) {
            sb.append("/" + temp.pop());
        }
        
        if (sb.length() == 0) {
            sb.append("/");
        }
        
        return sb.toString();
    }
}
