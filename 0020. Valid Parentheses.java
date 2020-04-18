// 方法：Stack
// Stack 先入后出的性质，帮助我们遇到前括号，压栈；遇到后括号,判断和栈顶元素是否匹配。
// HashMap 的使用：因为有三种类型的括号，需要--配对，且方便取用，key-value pair 就很合适用来表达。
// time: O(n)
// space: O(n)
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                // 第一种不匹配：栈为空
                if (stack.isEmpty()) {
                    return false;
                }
                // 第二种不匹配：括号类型不匹配
                if (c != map.get(stack.pop())) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
