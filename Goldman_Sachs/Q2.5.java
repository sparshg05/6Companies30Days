package Goldman_Sachs;

import java.util.*;

class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer,Integer> availabilityMap=new HashMap<>();
        HashMap<Integer,Integer> wantMap=new HashMap<>();
        for(int e:nums) availabilityMap.put(e,availabilityMap.getOrDefault(e,0)+1);

        for(int i=0;i<nums.length;i++){
            if(availabilityMap.getOrDefault(nums[i],0)<=0) continue;

            else if(wantMap.getOrDefault(nums[i],0)>0){
                availabilityMap.put(nums[i],availabilityMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i],wantMap.getOrDefault(nums[i],0)-1);
                wantMap.put(nums[i]+1 , wantMap.getOrDefault(nums[i]+1,0)+1);
            }
            else if(availabilityMap.getOrDefault(nums[i],0)>0 && availabilityMap.getOrDefault(nums[i]+1,0)>0 && availabilityMap.getOrDefault(nums[i]+2,0)>0){
                availabilityMap.put(nums[i],availabilityMap.getOrDefault(nums[i],0)-1);
                availabilityMap.put(nums[i]+1,availabilityMap.getOrDefault(nums[i]+1,0)-1);
                availabilityMap.put(nums[i]+2,availabilityMap.getOrDefault(nums[i]+2,0)-1);

                wantMap.put(nums[i]+3 , wantMap.getOrDefault(nums[i]+3,0)+1);
            }
            else return false;
        }

        return true;
    }
}
