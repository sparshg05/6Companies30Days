package Goldman_Sachs;

import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        int ans=Integer.MAX_VALUE;
        int head=0,tail=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(;head<cards.length;head++){
            map.put(cards[head],map.getOrDefault(cards[head],0)+1);
            while(map.get(cards[head])>1){
                ans = Math.min(ans , head-tail+1);
                map.put(cards[tail],map.get(cards[tail])-1);
                tail++;
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}