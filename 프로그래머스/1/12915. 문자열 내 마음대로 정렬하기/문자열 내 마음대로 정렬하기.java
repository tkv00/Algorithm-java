import java.util.*;
class Solution {
    static class CustomComparator implements Comparator<String>{
        private int n;
        CustomComparator(int n){
            this.n=n;
        }
        @Override
        public int compare(String o1,String o2){
            char c1=o1.charAt(n);
            char c2=o2.charAt(n);
            
            if(c1==c2){
                return o1.compareTo(o2);
            }
            return Character.compare(c1,c2);
        }
    }
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,new CustomComparator(n));
        return strings;
    }
}