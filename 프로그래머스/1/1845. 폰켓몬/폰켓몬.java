import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int result=0;
        HashSet<Integer> set=new HashSet<>();
        int size=nums.length;
        for(int i=0;i<size;i++){
            set.add(nums[i]);
        }
        if(size/2>set.size()){
            result=set.size();
        }else{
            result=size/2;
        }
        return result;
    }
}