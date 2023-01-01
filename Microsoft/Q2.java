package Microsoft;

import java.util.*;

class Solution {
    static int[] nums={1,2,3,4,5,6,7,8,9};
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        
        combinations(0,k,n,ans,new ArrayList<>());
        return ans;
    }
    
    public void combinations(int ind,int k,int n,List<List<Integer>> ans,List<Integer> list){
        
        if(list.size()==k){
            if(n==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        for(int i=ind;i<nums.length;i++){
            if(nums[i]<=n){
                list.add(nums[i]);
                combinations(i+1,k,n-nums[i],ans,list);
                list.remove(list.size()-1);
            }
            else break;
        }
    }
}
