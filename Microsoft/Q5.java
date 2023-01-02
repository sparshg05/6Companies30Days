package Microsoft;

import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        Arrays.fill(dp,1);
        
        int lastIndex=0;
        int max=1;
        for(int i=0;i<nums.length;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if( (nums[i]%nums[j]==0) && (1+dp[j]>dp[i]) ){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(max<dp[i]){
                max=dp[i];
                lastIndex=i;
            }
            
        }
        
        while(hash[lastIndex]!=lastIndex){
            ans.add(nums[lastIndex]);
            lastIndex=hash[lastIndex];
        }
        
        ans.add(nums[lastIndex]);
        return ans;
    }
}
