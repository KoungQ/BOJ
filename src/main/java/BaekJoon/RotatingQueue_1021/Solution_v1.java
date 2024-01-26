package BaekJoon.RotatingQueue_1021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_v1 {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 큐의 크기
        int size = sc.nextInt();
        // 큐 내부에 들어간 숫자 -> 다음 차례의 수가 이전 차례의 수에 영향을 끼치기 떄문에 저장
        List<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            queue.add(i);
        }

        // 뽑아내려는 수의 개수
        int cnt = sc.nextInt();
        for (int i = 0; i < cnt; i++) {
            // 수의 위치 == 지워야 하는 수
            int place = sc.nextInt();

            // 현재 위치가 큐의 맨 앞이 될때까지 rotate
            while (queue.indexOf(place) != 0) {
                int currentSize = size - i;

                if (currentSize % 2 == 0) {
                    // 현재 배열의 크기가 짝수라면
                    if (currentSize / 2 <= queue.indexOf(place)) {
                        moveRight(queue);
                    } else {
                        moveLeft(queue);
                    }
                } else {
                    // 홀수라면
                    if (currentSize / 2 + 1 <= queue.indexOf(place)) {
                        moveRight(queue);
                    } else {
                        moveLeft(queue);
                    }
                }
            }

            queue.remove(0);
        }

        System.out.println(result);
    }

    static List<Integer> moveRight(List<Integer> queue) {
        // 맨 뒤 추출
        int target = queue.remove(queue.size() - 1);
        // 앞에 붙이기
        queue.add(0, target);
        // 회전 횟수 증가
        result++;

        return queue;
    }

    static List<Integer> moveLeft(List<Integer> queue) {
        // 맨 앞 추출
        int target = queue.remove(0);

        // 맨 뒤에 붙이기
        queue.add(queue.size(), target);
        // 회전 횟수 증가
        result++;

        return queue;
    }
}
