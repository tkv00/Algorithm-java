class Solution {
    private static int answer=0;
    private static boolean[] visited;
    private static int size=0;
    
    private static void dfs(int dep,String word,String target,String[] words){
        if(word.equals(target)){
            answer=dep;
            return;
        }
        for(int i=0;i<size;i++){
            if(!visited[i]){
                String str=words[i];
                char[] ch=str.toCharArray();
                //word char배열
                char[] ch2=word.toCharArray();
                int k=0;
                for(int j=0;j<ch.length;j++){
                    if(ch[j]!=ch2[j]) k++;
                }
                if(k==1){
                    visited[i]=true;
                    dfs(dep+1,str,target,words);
                    visited[i]=false;
                }
            }
        }
    }
    public int solution(String begin, String target, String[] words) {
        size=words.length;
        visited=new boolean[size];
        dfs(0,begin,target,words);
        return answer;
    }
}