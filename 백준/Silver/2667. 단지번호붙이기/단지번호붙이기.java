import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


    public class Main { //메모리:14132KB 시간:140ms
        public static boolean[][] graph;
        public static int n;
        public static ArrayList<Integer> counts = new ArrayList<>();


        public static int dfs(int x, int y){
            /*graph의 초깃값이 모두 0이기때문에 1인 경우를 방문하지 않았다고 봄
             * 1을 만나면 방문처리를 함으로 하나의 dfs가 진행될때마다 count++을 진행
             */

            if(x<=-1 || x>=n || y<=-1 ||y>=n) return 0; //좌표가 공간을 넘어가면 바로 종료
            if (!graph[x][y]) return 0; // 현재 위치가 빈 칸이면 0을 반환

            int count = 1;

            graph[x][y] = false; //현재위치 방문처리

            count+=dfs(x-1,y);
            count+=dfs(x,y-1);
            count+=dfs(x+1,y);
            count+=dfs(x,y+1);

            return count;

        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            graph = new boolean[n][n];


            //이차원 배열 입력받고 저장
            for(int i = 0; i<n; i++){
                String str = br.readLine();
                for(int j = 0; j<n; j++){
                    graph[i][j] = str.charAt(j) == '1';
                }
            }

            for(int i = 0; i<n; i++){
                for(int j = 0; j<n; j++){
                    int totalCount = dfs(i,j);
                    if(totalCount>0){ //하나이상의 집을 세었다면
                        counts.add(totalCount);
                    }
                }
            }

            Collections.sort(counts); //오름차순 후 출력
            System.out.println(counts.size());
            for(Integer i: counts){
                System.out.println(i);
            }


        }
    }
