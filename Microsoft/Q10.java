package Microsoft;

import java.util.*;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int start=0,end=0;
        if(n==1) return 0;

        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
            if(nums[i]<maxi){
                end=i;
            }
        }
        for(int i=n-1;i>=0;i--){
            mini=Math.min(mini,nums[i]);
            if(nums[i]>mini){
                start=i;
            }
        }

        return (end>0)?end-start+1:0;
    }
}