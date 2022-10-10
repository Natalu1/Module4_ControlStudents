import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {

    public static double median(List<Double> studentsMarks) {
        List<Double> copyMarks = new ArrayList<>(studentsMarks);
        Collections.sort(copyMarks);
        double median = 0;
        if (copyMarks.size() % 2 == 1) {
            median = copyMarks.get(copyMarks.size() / 2);
        } else {
            double lower = copyMarks.get(copyMarks.size() / 2 - 1);
            double upper = copyMarks.get(copyMarks.size() / 2);

            median = (lower + upper) / 2.0;
        }
        return median;
    }

    public static String persentAmountStudents(int amountPerYear, int allStudents) {
        double percent = (double) amountPerYear / allStudents * 100;
        return String.format("%.1f", percent);
    }
}
