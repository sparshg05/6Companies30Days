package Microsoft;

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<Integer>[] goCourses = new List[numCourses];
        
        for(int i=0;i<numCourses;i++){
            goCourses[i]=new ArrayList<Integer>();
        }
        
        for(int[] pair:prerequisites){
            inDegree[pair[0]]++;
            goCourses[pair[1]].add(pair[0]);
        }
        
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) que.add(i);
        }
        
        int cnt=0;
        while(que.size()>0){
            int n=que.remove();
            
            cnt++;
            for(int e:goCourses[n]){
                if(--inDegree[e]==0){
                    que.add(e);
                }
            }
        }
        
        return cnt==numCourses;
    }
    
    
}