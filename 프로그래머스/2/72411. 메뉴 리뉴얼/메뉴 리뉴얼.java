import java.util.*;
import java.io.*;
class Solution {
    /**
    최소 2가지 이상의 단품 메뉴 구성
    최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합.
    **/
    /**
    정답 : 오름차순 정렬
    **/

    private static StringBuilder sb;
    //< course(가능 단일 코스 개수) , < 코스 문자열 , 문자열 빈도 수 > >
    private static Map<Integer,Map<String,Integer>> courseMap;
    //course 인수 - 최대 반복? 수
    private static Map<Integer,Integer> maxMap;
    private static List<String> result;
    public String[] solution(String[] orders, int[] course) {
        courseMap=new HashMap<>();
        maxMap=new HashMap<>();
        result=new ArrayList<>();
        
        for(int x:course){
            courseMap.put(x,new HashMap<>());
        }
        
        for(String str:orders){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            combination(0,arr,new ArrayList<>());
        }
        
        for(int x:courseMap.keySet()){
            int max=0;
            Map<String,Integer> info=courseMap.get(x);
            for(String key:info.keySet()){
                if(info.get(key)>=2) max=Math.max(max,info.get(key));
            }
            maxMap.put(x,max);
        }
        
        for(int x:courseMap.keySet()){
            Map<String,Integer> info=courseMap.get(x);
            for(String key:info.keySet()){
                if(info.get(key)==maxMap.get(x) && maxMap.get(x)>=2){
                    result.add(key);
                }
            }
        }
        
        Collections.sort(result);
        
        String[] answer=new String[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i]=result.get(i);
        }
        
        return answer;
    }
    
    private static void combination(int idx,char[] arr,List<Character> list){
        //코스의 길이에 맞는 문자열 존재 시
        if(courseMap.containsKey(list.size())){
            Map<String,Integer> map=courseMap.get(list.size());
            String str=toString(list);
            map.put(str,map.getOrDefault(str,0)+1);
            
            courseMap.put(list.size(),map);
        }
        
        for(int i=idx;i<arr.length;i++){
            list.add(arr[i]);
            combination(i+1,arr,list);
            list.remove(list.size()-1);
        }
        
        
    }
    
    //정렬 후 list -> String
    private static String toString(List<Character> list){
        Collections.sort(list);
        sb=new StringBuilder();
        for(char c:list){
            sb.append(c);
        }
        return sb.toString();
    }
}