import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();    // 테스트 케이스 수 입력

        for(int i = 0; i < testCase; i++) {
            int fileCnt = sc.nextInt();     // 파일 수 입력
            int targetIndex = sc.nextInt();      // 타겟 파일 인덱스 입력
            int[] target = new int[2];

            LinkedList<int[]> fileList = new LinkedList<>();    // int[입력 순서, 중요도]

            for(int j = 0; j < fileCnt; j++) {
                fileList.add(new int[] {j, sc.nextInt()});  // 파일 중요도 입력 받기

                if(j == targetIndex) {
                    target = fileList.getLast();
                }
            }

            int result = 0;
            while (true) {
                int[] max = fileList.get(0);    // int[입력 순서, 중요도]

                for (int j = 1; j < fileList.size(); j++) {     // 중요도 최댓값 찾기
                    if(fileList.get(j)[1] > max[1]) {
                        max = fileList.get(j);
                    }
                }

                for (int j = 0; fileList.get(0)[0] != max[0]; j++) {  // 맨 앞에 꺼내서 맨 뒤에 갖다 붙이기
                    fileList.add(fileList.poll());
                }


                int[] remove = fileList.pollFirst(); // 최대 중요도 파일 처리

                ++result;   // 결과 + 1

                if(remove == target) {
                    System.out.println(result); // 파일 찾았으면 결과 출력
                    break;
                }
            }
        }
    }
}
