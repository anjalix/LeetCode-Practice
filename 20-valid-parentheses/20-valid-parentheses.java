class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        int n = s.length();
        if(n%2!=0) return false;
        char c,d;
        for(int i = 0;i<n;i++)
        {
            c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.empty())
                    return false;
                d = stack.pop();
                if(!((d == '(' && c == ')') || (d == '{' && c == '}')  || (d == '[' && c == ']') ))
                    return false;
            }
        }
        return (stack.empty());
    }
}