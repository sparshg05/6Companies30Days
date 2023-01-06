package Microsoft;

import java.util.*;

class Solution {
    public int numberOfSubstrings(String s) {
        int i=-1,j=-1;
        int n=s.length();
        int ans=0;
        HashMap<Character,Integer> map=new HashMap<>();
        
        while(true){
            boolean f1=false,f2=false;
            
            while(i<n-1){
                f1=true;
                i++;
                char ch=s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                
                if(map.size()==3){
                    ans = ans + (n-i);
                    break;
                }
                
            }
            
            while(j<i){
                f2=true;
                j++;
                char ch=s.charAt(j);
                if(map.get(ch)==1){
                    map.remove(ch);
                    break;
                }
                else map.put(ch,map.get(ch)-1);
                
                if(map.size()==3){
                    ans=ans+(n-i);
                    // break;
                }
                
            }
            
            if(f1==false && f2==false) break;
        }
        
        return ans;
    }
}