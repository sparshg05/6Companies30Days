package Microsoft;

import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("/")
                ||tokens[i].equals("*")){
                int x=st.pop();
                int y=st.pop();

                if(tokens[i].equals("+")){
                    int a=x+y;
                    st.push(a);
                }
                else if(tokens[i].equals("-")){
                    int a=y-x;
                    st.push(a);
                }
                else if(tokens[i].equals("*")){
                    int a=x*y;
                    st.push(a);
                }
                else{
                    int a=y/x;
                    st.push(a);
                }
            }
            else{
                int x=Integer.parseInt(tokens[i]);
                st.push(x);
            }
        }

        return st.pop();
    }
}