package Microsoft;

import java.util.*;

class Solution {
    public String getHint(String secret, String guess) {
        int bulls=0,cows=0;
        HashSet<Integer> bset=new HashSet<>();
        HashMap<Integer,Integer> cmap=new HashMap<>();

        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
                bset.add(i);
            }
        }
        for(int i=0;i<secret.length();i++){
            if(bset.contains(i)==false){
                int num=secret.charAt(i)-'0';
                cmap.put(num,cmap.getOrDefault(num,0)+1);
            }
        }

        for(int i=0;i<secret.length();i++){
            if(bset.contains(i)==false){
                int num=guess.charAt(i)-'0';
                if(cmap.containsKey(num)==true){
                    cows++;
                    if(cmap.get(num)==1) cmap.remove(num);
                    else cmap.put(num,cmap.get(num)-1);
                }
            }
        }

        String s=bulls+"A"+cows+"B";
        return s;
    }
}
