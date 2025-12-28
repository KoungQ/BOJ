import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Double> score = new HashMap<>();
        score.put("A+", 4.5);
        score.put("A0", 4.0);
        score.put("B+", 3.5);
        score.put("B0", 3.0);
        score.put("C+", 2.5);
        score.put("C0", 2.0);
        score.put("D+", 1.5);
        score.put("D0", 1.0);
        score.put("F", 0.0);

        double sumCredit = 0.0;
        double sumWeighted = 0.0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (grade.equals("P")) continue;

            sumCredit += credit;
            sumWeighted += credit * score.get(grade);
        }

        double gpa = sumWeighted / sumCredit;
        System.out.printf("%.6f%n", gpa);
    }
}
