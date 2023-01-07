package Goldman_Sachs;

import java.util.*;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int cnt=0;
        for(int i=0;i<points.length;i++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j) continue;

                int d1=Math.abs(points[j][1]-points[i][1]);
                int d2=Math.abs(points[j][0]-points[i][0]);
                int dist=d1*d1+d2*d2;
                map.put(dist,map.getOrDefault(dist,0)+1);
            }

            for(int val:map.values()){
                cnt += val*(val-1);
            }
        }

        return cnt;
    }
}