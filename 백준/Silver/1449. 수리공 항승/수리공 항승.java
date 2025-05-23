import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();       // 물이 새는 곳의 개수
        int l = sc.nextInt();       // 테이프 길이
        List<Integer> list = new ArrayList<>();     // 물이 새는 곳

        for(int i = 0; i < n; i++)
            list.add(sc.nextInt());

        list.sort(Comparator.naturalOrder());

        int result = 0;
        while(true) {
            if (list.isEmpty()) {
                break;
            }

            if(list.size() == 1) {
                result++;
                break;
            }

            int pivot = list.get(0);
            Integer target = list.get(1);

            if ((target - pivot) + 1 <= l) {
                list.remove(target);
            } else {
                list.remove(0);
                result++;
            }
        }

        System.out.println(result);
    }
}
