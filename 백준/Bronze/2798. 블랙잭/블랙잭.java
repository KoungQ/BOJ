import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for(int fir = 0; fir < N - 2; fir++) {
            for(int sec = fir + 1; sec < N - 1; sec++) {
                for(int thr = sec + 1; thr < N; thr++) {
                    int sum = arr[fir] + arr[sec] + arr[thr];

                    if(M >= sum)
                        if(res < sum)
                            res = sum;
                }
            }
        }

        System.out.println(res);
    }

}
