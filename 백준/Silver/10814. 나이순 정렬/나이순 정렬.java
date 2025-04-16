import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static String[][] members;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 단어 개수 입력 받기

        members = new String[n][3];  // [입력 순서, 나이, 이름]
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new String[] {String.valueOf(i), String.valueOf(age), name};
        }

        heapSort();

        StringBuilder sb = new StringBuilder();
        for (String[] member : members) {
            sb.append(member[1]).append(" ").append(member[2]).append("\n");
        }

        System.out.println(sb);
    }

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

    private static void swap(int i, int j) {
        String[] temp = new String[] {members[i][0], members[i][1], members[i][2]};
        members[i] = members[j];
        members[j] = temp;
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

    static boolean compare(int idx1, int idx2) {
        if(Integer.parseInt(members[idx1][1]) > Integer.parseInt(members[idx2][1])) {
            return true;
        } else if(Integer.parseInt(members[idx1][1]) == Integer.parseInt(members[idx2][1])) {  // 나이가 같다면
            return Integer.parseInt(members[idx1][0]) > Integer.parseInt(members[idx2][0]);
        }
        return false;
    }
}
