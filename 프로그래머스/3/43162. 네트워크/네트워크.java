import java.util.*;

 class Solution {
        private static int[] arr;
        private Set<Integer> set;
        private static int getParent(int a){
            if(a==arr[a]) return a;
            return arr[a]=getParent(arr[a]);
        }
        private static void union(int a,int b){
            a=getParent(a);
            b=getParent(b);
            if(a>b){
                for(int i=0;i<arr.length;i++){
                    if(a==arr[i]) arr[i]=b;
                }
                arr[a]=b;
            }else{
                for(int i=0;i<arr.length;i++){
                    if(b==arr[i]) arr[i]=a;
                }
                arr[b]=a;
            }
        }
        private static boolean isSameParent(int a,int b){
            a=getParent(a);
            b=getParent(b);
            return a==b;
        }


        public int solution(int n, int[][] computers) {
            arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=i;
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i==j) continue;
                    //네트워크가 연결되어 있는 경우
                    if(computers[i][j]==1){
                        //이미 같은 집합인 경우
                        if(isSameParent(i,j)) continue;
                        //다른 집합인 경우
                        union(i,j);
                    }
                }
            }
            set=new HashSet<>();
            for(int x:arr){
                set.add(x);
            }
            return set.size();
        }
    }