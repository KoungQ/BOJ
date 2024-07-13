package BOJ.시리얼_번호_1431;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class solution {

    static LinkedList<char[]> serialNumbers = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 기타 개수 입력 받기

        for (int i = 0; i < n; i++) {       // 시리얼 번호 입력 받기
            st = new StringTokenizer(br.readLine());
            char[] serialNumber = st.nextToken().toCharArray();

            serialNumbers.add(serialNumber);
        }

//        bubbleSort();     // 버블 정렬
        selectionSort();    // 선택 정렬

        serialNumbers.listIterator().forEachRemaining(System.out::println);     // 출력
    }

    // 메모리: 17324KB, 시간 192ms
    static void bubbleSort() {
        for(int i = serialNumbers.size() - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(compare(serialNumbers.get(j), serialNumbers.get(j + 1)))
                    swap(serialNumbers.get(j), serialNumbers.get(j + 1));
            }
        }
    }

    // 메모리: 16884KB, 시간: 180ms
    static void selectionSort() {
        for(int i = 0; i < serialNumbers.size(); i++) {
            int minIdx = i;

            for(int j = i + 1; j < serialNumbers.size(); j++) {
                if(compare(serialNumbers.get(minIdx), serialNumbers.get(j)))
                    minIdx = j;
            }

            swap(serialNumbers.get(minIdx), serialNumbers.get(i));
        }
    }

    public static boolean compare(char[] num1, char[] num2) {
        int numLen1 = num1.length;
        int numLen2 = num2.length;

        if(numLen1 > numLen2) { // 1. 길이 순으로 앞 인덱스가 더 크다면 swap
            // swap
            return true;
        } else if(numLen1 == numLen2) { // 같다면 다음 연산
            int sum1 = 0, sum2 = 0;

            for(int k = 0; k < numLen1; k++) {
                if(Character.isDigit(num1[k])) {  // 문자열 내에 있는 숫자들의 합
                    sum1 += num1[k] - '0';
                }

                if(Character.isDigit(num2[k])) {  // 문자열 내에 있는 숫자들의 합
                    sum2 += num2[k] - '0';
                }
            }

            if(sum1 > sum2) {   // 2. 시리얼 넘버 중 숫자들의 합이 더 크다면 swap
                return true;
            } else if (sum1 == sum2) {  // 같다면 다음 연산
                // 3. 사전 순으로 정렬
                return Arrays.toString(num1).compareTo(Arrays.toString(num2)) > 0;
            }   // 숫자 값이 더 작다면 그대로 앞에 두기
        }   // 길이가 더 작다면 그대로 앞에 두기

        return false;
    }

    public static void swap(char[] ele1, char[] ele2) {
        int index1 = serialNumbers.indexOf(ele1);
        int index2 = serialNumbers.indexOf(ele2);

        serialNumbers.set(index1, ele2);
        serialNumbers.set(index2, ele1);
    }
}
