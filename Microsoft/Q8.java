package Microsoft;

import java.util.*;

class Solution {
    int maxSum=Integer.MIN_VALUE;
    List<Integer> b2a=new ArrayList<>();

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<amount.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        //getting bob path
        HashSet<Integer> vis=new HashSet<>();
        vis.add(bob);
        List<Integer> l=new ArrayList<>();
        l.add(bob);
        dfs(bob,0,adj,vis,l);

        //As before intersection all amount will become 0 by bob
        for(int i=0;i<b2a.size()/2;i++){
            amount[b2a.get(i)]=0;
        }
        if(b2a.size()%2!=0){
            int n=b2a.get(b2a.size()/2);
            amount[n]/=2;
        }

        // HashSet<Integer> vis=new HashSet<>();
        vis.clear();
        vis.add(0);
        getMaxPath(0,adj,vis,amount,amount[0]);

        return maxSum;
    }

    public void getMaxPath(int node,List<List<Integer>> adj,HashSet<Integer> vis,int[] amount,
                            int curSum){
        int cnt=0;
        for(int e:adj.get(node)){
            if(vis.contains(e)==false){
                vis.add(e);
                getMaxPath(e,adj,vis,amount,curSum + amount[e]);
                vis.remove(e);
                cnt++;
                // System.out.println("e: "+e+" cnt: "+cnt);
            }
        }

        if(cnt==0) maxSum = Math.max(maxSum , curSum);
        return ;
    }

    public boolean dfs(int node,int target,List<List<Integer>> adj,HashSet<Integer> vis,
                        List<Integer> list){
        if(node==target){
            b2a=new ArrayList<>(list);
            return true;
        }

        for(int e:adj.get(node)){
            if(vis.contains(e)==false){
                vis.add(e);
                list.add(e);
                if(dfs(e,target,adj,vis,list)) return true;
                list.remove(list.size()-1);
                vis.remove(e);
            }
        }
        return false;
    } 
}
