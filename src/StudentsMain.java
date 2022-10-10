import java.util.List;

public class StudentsMain {
    public static void main(String[] args) {
        FileRider studentsParser = new FileRider("files/students.txt");
        List<Student> studentsList = studentsParser.getStudentFromFile();
        studentsList.forEach(System.out::println);

        Reports.reportMedianMarks(studentsList);
        Reports.reportStudentsPercent(studentsList);
        Reports.preparePerYearReport(studentsList);
        Reports.preparePerYearReportSorted(studentsList);
    }
}
