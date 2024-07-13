package BOJ.빈도_정렬_2910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class solution {

    private static List<int[]> nums = new ArrayList<>();      // 초기값
    private static List<int[]> sorted = new ArrayList<>();    // 임시 저장소

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 메세지 길이 입력 받기
        int c = Integer.parseInt(st.nextToken());   // 가장 큰 수 입력 받기

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());     // 초기 값 입력받기

            boolean isFound = false;
            for (int[] num : nums) {
                if (num[0] == input) {
                    num[1]++;
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                nums.add(new int[]{input, 1});
            }
        }

        init();

        StringBuilder sb = new StringBuilder();
        for (int[] num : nums) {
            System.out.println(num[0]);
            for(int i = 0; i < num[1]; i++) {
                sb.append(num[0]).append(" ");
            }
        }

//        System.out.println(Arrays.toString(sorted));
        System.out.println(sb);
    }

    public static void init() {
        mergeSort(0, nums.size() - 1);
        sorted = null;
    }

    // Top-Down 방식 구현
    private static void mergeSort(int left, int right) {

        if (left == right) return;

        int mid = (left + right) / 2;    // 절반 위치

        mergeSort(left, mid);        // 절반 중 왼쪽 부분리스트(left ~ mid)
        mergeSort(mid + 1, right);    // 절반 중 오른쪽 부분리스트(mid+1 ~ right)

        merge(left, mid, right);        // 병합작업

    }

    static void set(int idx1, int idx2) {
        if(nums.size() < idx1) {
            sorted.set(idx1, nums.get(idx2));
        } else {
            sorted.add(nums.get(idx2));
        }
    }

    private static void merge(int left, int mid, int right) {
        int l = left;        // 왼쪽 부분리스트 시작점
        int r = mid + 1;    // 오른쪽 부분리스트의 시작점
        int idx = left;        // 채워넣을 배열의 인덱스


        while (l <= mid && r <= right) {
            if (nums.get(l)[1] <= nums.get(r)[1]) {
//                sorted.set(idx, nums.get(l));
                set(idx, l);
                idx++;
                l++;
            } else {
//                sorted.set(idx, nums.get(r));
                set(idx, r);
                idx++;
                r++;
            }
        }

        if (l > mid) {
            while (r <= right) {
//                sorted.set(idx, nums.get(r));
                set(idx, r);
                idx++;
                r++;
            }
        } else {
            while (l <= mid) {
//                sorted.set(idx, nums.get(l));
                set(idx, l);
                idx++;
                l++;
            }
        }

        for (int i = left; i <= right; i++) {
            int[] tmp = new int[2];
            for (int[] num : nums) {
                if(num[0] == sorted.get(i)[0])
                    tmp = num;
            }

            nums.set(i, tmp);
        }
    }
}
