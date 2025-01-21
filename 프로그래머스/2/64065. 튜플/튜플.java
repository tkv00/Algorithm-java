import java.util.*;

class Solution {
    public int[] solution(String s) {
        //순서가 다르면 -> 다른 튜플
        String str=s.substring(2,s.length()-2).replace("{","");
        
        String[] arr=str.split("},");
        int[] result=new int[arr.length];
        
        Arrays.sort(arr,(o1,o2)->Integer.compare(o1.length(),o2.length()));
        HashSet<String> set=new HashSet<>();
        
        for(int i=0;i<arr.length;i++){
            String[] strArray=arr[i].split(",");
            for(int j=0;j<strArray.length;j++){
                //set에 없으면 정답 배열에 추가
                if(!set.contains(strArray[j])){
                    result[i]=Integer.parseInt(strArray[j]);
                    set.add(strArray[j]);
                }
            }
        }
        return result;
    }
}