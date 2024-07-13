package BOJ.나이순_정렬_10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class solution {

    private static String[][] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 멤버 수 입력 받기

        members = new String[n][3];  // [입력 순서, 나이, 이름]
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new String[] {String.valueOf(i), String.valueOf(age), name};
        }

//        heapSort();
        countingSort();

//        StringBuilder sb = new StringBuilder();
//        for (String[] member : members) {
//            sb.append(member[1]).append(" ").append(member[2]).append("\n");
//        }
//
//        System.out.println(sb);
    }

    // 메모리: 115804KB, 시간: 1160ms
    private static void heapSort() {
        int size = members.length;

        if(size < 2) {
            return;
        }

        int parentIdx = getParent(size - 1);

        for(int i = parentIdx; i >= 0; i--) {
            heapify(i, size - 1);
        }

        for(int i = size - 1; i > 0; i--) {
            swap(0, i);
            heapify(0, i - 1);
        }
    }


    private static int getParent(int child) {
        return (child - 1) / 2;
    }


    private static void heapify(int parentIdx, int lastIdx) {
        int leftChildIdx;
        int rightChildIdx;
        int largestIdx;

        while((parentIdx * 2) + 1 <= lastIdx) {
            leftChildIdx = (parentIdx * 2) + 1;
            rightChildIdx = (parentIdx * 2) + 2;
            largestIdx = parentIdx;

            if (compare(leftChildIdx, largestIdx)) {
                largestIdx = leftChildIdx;
            }

            if (rightChildIdx <= lastIdx && compare(rightChildIdx, largestIdx)) {
                largestIdx = rightChildIdx;
            }

            if (largestIdx != parentIdx) {
                swap(parentIdx, largestIdx);
                parentIdx = largestIdx;
            } else {
                return;
            }
        }
    }

    // 계수 정렬: 정렬은 되나.. 조건이 여러개일 뿐더러 저장해야 할 값이 여러개이므로 나이 순으로만 출력해봄
    private static void countingSort() {
        int[] counting = new int[200];    // 최소 나이: 1 (0) ~ 최대 나이: 200 (199)
        int[] result = new int[200];

        for(int i = 0; i < members.length; i++) {
            counting[Integer.parseInt(members[i][1])]++;
        }

        for(int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        for(int i = members.length - 1; i >= 0; i--) {
            int value = Integer.parseInt(members[i][1]);
            counting[value]--;
            result[counting[value]] = value;
        }

        System.out.println("result[]");
        for(int i = 0; i < result.length; i++) {
            if(result[i] == 0)
                continue;
            System.out.print(result[i] + "\t");
        }
        System.out.println();
    }

    private static void swap(int i, int j) {
        String[] temp = new String[] {members[i][0], members[i][1], members[i][2]};
        members[i] = members[j];
        members[j] = temp;
    }

    private static boolean compare(int idx1, int idx2) {
        if(Integer.parseInt(members[idx1][1]) > Integer.parseInt(members[idx2][1])) {
            return true;
        } else if(Integer.parseInt(members[idx1][1]) == Integer.parseInt(members[idx2][1])) {  // 나이가 같다면
            return Integer.parseInt(members[idx1][0]) > Integer.parseInt(members[idx2][0]);
        }
        return false;
    }
}
