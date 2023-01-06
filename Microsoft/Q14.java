package Microsoft;

import java.util.*;

class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int n=nums.length;
        
        int g=numsDivide[0],temp;
        for(int e:numsDivide){
            while(e>0){
                temp = g%e;
                g = e;
                e = temp;
            }
        }
        
        Arrays.sort(nums);
        
        int i=0;
        for(;i<n;i++){
            if(g%nums[i]==0){
                break;
            }
        }
        
        if(i==n) return -1;
        else return i;
    }
}