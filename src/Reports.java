import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reports {

    public static void reportMedianMarks(List<Student> students) {
        Map<String, List<Student>> studentYearMap = getStudentYearMap(students);
        List<String> medianaLines = studentYearMap.entrySet().stream().map(entry -> {
            List<Double> studentsMarks = entry.getValue().stream()
                    .map(Student::getFinalGrade).collect(Collectors.toList());
            return "Year " + entry.getKey() + " - " + entry.getValue().size() + " - " + "students - mediana: "
                    + Calculator.median(studentsMarks);
        }).collect(Collectors.toList());

        printReport("Report mediana:", medianaLines);
        FileWriter.writeFile("files/reportMediana.txt", medianaLines);
    }

    public static void reportStudentsPercent(List<Student> students) {
        Map<String, List<Student>> studentYearMap = getStudentYearMap(students);
        List<String> percentLines = studentYearMap.entrySet().stream().map(entry -> {
            List<Double> studentsMarks = entry.getValue().stream()
                    .map(Student::getFinalGrade).collect(Collectors.toList());

            int studentsPerYear = entry.getValue().size();
            return "Year " + entry.getKey() + " - " + studentsPerYear + " - " + "students - mediana: "
                    + Calculator.median(studentsMarks) + " on this year studies "
                    + Calculator.persentAmountStudents(studentsPerYear, students.size()) + "% students";
        }).collect(Collectors.toList());

        printReport("Report mediana and students percent:", percentLines);
        FileWriter.writeFile("files/reportStudentsPercent.txt", percentLines);
    }
    public static void preparePerYearReport(List<Student> students) {
        Map<String, List<Student>> studentYearMap = getStudentYearMap(students);
        List<String> reportLines = new ArrayList<>();
        studentYearMap.entrySet().stream().forEach(entry -> {
            reportLines.add("- Year " + entry.getKey() + " -");
            entry.getValue().forEach(student -> reportLines.add(student.getPesel() + " - " + student.getFirstName() + " "
                    + student.getLastName()));
        });

        printReport("Report per year:", reportLines);
        FileWriter.writeFile("files/reportPerYear.txt", reportLines);
    }

    public static void preparePerYearReportSorted(List<Student> students) {
        Map<String, List<Student>> studentYearMap = getStudentYearMap(students);
        List<String> reportLines = new ArrayList<>();
        Comparator<Student> compareBySex = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getSex().compareTo(o2.getSex());
            }
        };

        studentYearMap.entrySet().stream().forEach(entry -> {
            reportLines.add("- Year " + entry.getKey() + " -");
            entry.getValue().stream().sorted(compareBySex).forEach(student -> reportLines.add(student.getPesel() + " - "
                    + student.getFirstName() + " " + student.getLastName()));
        });

        printReport("Report per year sorted by sex:", reportLines);
        FileWriter.writeFile("files/reportPerYearSorted.txt", reportLines);
    }

    private static Map<String, List<Student>> getStudentYearMap(List<Student> students) {
        Map<String, List<Student>> studentYearMap = students.stream().collect(Collectors.groupingBy(student -> student.getYear()));
        return studentYearMap;
    }

    private static void printReport(String name, List<String> listToPrint) {
        System.out.println("\n" + name);
        listToPrint.stream().forEach(System.out::println);
    }
}
