package Microsoft;

import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<Node>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            List<Node> list=new ArrayList<>();
            adj.add(list);
        }
        
        for(int[] l:roads){
            adj.get(l[0]).add(new Node(l[1],l[2]));
            adj.get(l[1]).add(new Node(l[0],l[2]));
        }
        
        long[] dist=new long[n];
        long[] ways=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        
        PriorityQueue<long []> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        pq.add(new long[]{0,0});
        dist[0]=0;
        ways[0]=1;
        
        int ans=0;
        while(pq.size()>0){
            long[] r=pq.poll();
            
            for(Node it:adj.get((int)r[0])){
                int newV=it.v;
                long newWt=it.wt + r[1];
                
                if(newWt < dist[newV]){
                    ways[newV] = ways[(int)r[0]];
                    dist[newV] = newWt;
                    pq.add(new long[]{newV , dist[newV]});
                }
                else if(newWt==dist[newV]){
                    ways[newV] = (ways[newV] + ways[(int)r[0]])%1000000007;
                }
            }
            
        }
        
        return (int)ways[n-1]%1000000007;
    }
}
class Node{
    int v;
    long wt;
    Node(int a,long b){
        v=a;
        wt=b;
    }
}
