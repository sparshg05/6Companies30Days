package Microsoft;

import java.util.*;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int f=0;
        int s=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            f+=nums[i]*i;
            s+=nums[i];
        }

        int ans=f;
        int i=1;
        while(i<n){
            f=f+s-(n*nums[n-i]);
            ans=Math.max(ans,f);
            i++;
        }

        return ans;
    }
}