import java.util.*;

class Solution {
    static class CustomComparator implements Comparator<String>{
        @Override
        public int compare(String o1,String o2){
            String str1=o1+o2;
            String str2=o2+o1;
            return str2.compareTo(str1);
        }
    }
    public String solution(int[] numbers) {
        String[]str=new String[numbers.length];
        
        for(int i=0;i<numbers.length;i++){
            str[i]=String.valueOf(numbers[i]);
        }
        
        
        Arrays.sort(str,new CustomComparator());
        if(str[0].equals("0")){
            return "0";
        }
        
        StringBuilder sb=new StringBuilder();
        for(String k:str){
            sb.append(k);
        }
        return sb.toString();
    }
}