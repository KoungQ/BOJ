package BOJ.단어_정렬_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class solution {

    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 단어 개수 입력 받기

        words = new String[n];

        for (int i = 0; i < n; i++) {       // 시리얼 번호 입력 받기
            st = new StringTokenizer(br.readLine());

            String word = st.nextToken();
            words[i] = word;
        }

        words = new HashSet<>(Arrays.asList(words)).toArray(new String[0]); // List -> Set -> List (중복 제거)

        insertionSort();
//        quickSort(0, words.length - 1);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }

    // 메모리: 25240KB, 시간: 1604ms
    static void insertionSort() {
        for (int i = 1; i < words.length; i++) {
            String target = words[i];

            int j = i - 1;
            while (j >= 0 && compare(words[j], target)) {
                words[j + 1] = words[j];
                j--;
            }

            words[j + 1] = target;
        }
    }

    // 메모리: 27208KB, 시간: 436ms
    static void quickSort(int low, int high) { // low, high == index
        if (low >= high) { //  종료조건
            return;
        }

        int pivot = low + (high - low) / 2;
        String pivotValue = words[pivot];

        int left = low;
        int right = high;
        while (left <= right) {
            while (compare(pivotValue, words[left])) {
                left++;
            }

            while (compare(words[right], pivotValue)) {
                right--;
            }

            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }

        quickSort(low, right);
        quickSort(left, high);
    }

    static boolean compare(String word1, String word2) {
        if (word1.length() > word2.length()) {
            return true;
        } else if (word1.length() == word2.length()) {
            return word1.compareTo(word2) > 0;
        }

        return false;
    }

    public static void swap(int index1, int index2) {
        String value1 = words[index1];
        String value2 = words[index2];

        words[index1] = value2;
        words[index2] = value1;
    }
}
