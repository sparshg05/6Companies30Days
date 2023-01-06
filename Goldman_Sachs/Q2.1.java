package Goldman_Sachs;

import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n==1) return 1;

        int cnt=1;
        for(int i=0;i<n;i++){
            HashMap<Double,Integer> map=new HashMap<>();
            for(int j=0;j<n;j++){
                if(j!=i){
                    double angle=Math.atan2(points[j][1]-points[i][1],points[j][0]-points[i][0]);
                    map.put(angle,map.getOrDefault(angle,0)+1);
                }
            }

            for(double a:map.keySet()){
                cnt = Math.max(cnt , map.get(a));
            }
            
        }

        return cnt+1;
    }
}