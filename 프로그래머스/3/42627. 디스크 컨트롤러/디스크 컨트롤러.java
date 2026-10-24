import java.util.*;
import java.io.*;

class Solution {
    //작업 번호, 작업 요청 시각, 작업 소요 시간
    
    //우선순위 
    //1. 작업 소요 시간 짧은 것
    //2. 작업 요청 시각 빠른 것
    //3. 작업 번호 작은 것
    static class Job{
        int start;
        int index;
        int jobTime;
        
        Job(int start,int index,int jobTime){
            this.start=start;
            this.index=index;
            this.jobTime = jobTime;
        }
    }
    static int[][] timeTable; //{인덱스, }
    static int[] endTimes;
    static PriorityQueue<Job> pq;
    
    static int operation(int[][] jobs){
        int n = jobs.length;
        timeTable=new int[n][2];
        Job[] sorted = new Job[n];
        
        for(int i=0;i<n;i++){
            int[] job = jobs[i];
            
            sorted[i] = new Job(job[0],i,job[1]);
        }
        
        Arrays.sort(sorted,(a,b)->{
            if(a.start != b.start){
                return Integer.compare(a.start,b.start);
            }
            return Integer.compare(a.jobTime,b.jobTime);
        });
        
        pq = new PriorityQueue<>((a,b)->{
            if(a.jobTime!=b.jobTime){
                return Integer.compare(a.jobTime,b.jobTime);
            }
            
            if(a.start!=b.start){
                return Integer.compare(a.start,b.start);
            }

            return Integer.compare(a.jobTime,b.jobTime);
            
        });
        
        
        int time=0;
        int idx=0;
        int cnt=0;
        int total=0;
        
        while(cnt < n){
            while(idx < n && time>=sorted[idx].start){
                pq.offer(sorted[idx]);
                idx++;
            }
            
            //작업이 없는 겨웅
            if(pq.isEmpty()){
                time = sorted[idx].start;
                continue;
            }
            
            Job now = pq.poll();
            cnt++;
            time += now.jobTime;
            total += (time - now.start);
        }
        
        return (int)(total/n);
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        return operation(jobs);
    }
}