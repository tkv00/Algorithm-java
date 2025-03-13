import java.util.*;

class Solution {
    private static List<Integer> k=new ArrayList<>();
    private static List<Integer> result=new ArrayList<>();

    private static void plus(int[] person,int[] answers){
    
    int size=person.length;
    int caseSize=answers.length;
    int cnt=0;
    
    for(int i=0;i<caseSize ;i++){
        if(person[i%size]==answers[i]){
            cnt++;
            }
        }
        //문제 맞힌 횟수
        result.add(cnt);
    }
    public int[] solution(int[] answers) {
        int[] person1={1,2,3,4,5};
        int[] person2={2,1,2,3,2,4,2,5};
        int[] person3={3,3,1,1,2,2,4,4,5,5};
        int size=answers.length;
           
        //1번 사람
        plus(person1,answers);
        //2번 사람
        plus(person2,answers);
        //3번 사람
        plus(person3,answers);
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            //제일 큰 값 찾기
            if(max<=result.get(i)){
                max=result.get(i);
            }
        }
        for(int i=0;i<3;i++){
            if(max==result.get(i)){
                k.add(i+1);
            }
        }
        return k.stream().mapToInt(i->i).toArray();
        
    }
}