import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileRider {
    private Path filePath;

    public FileRider(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public List<String> getLinesFromFile() {

        try {
            return Files.readAllLines(this.filePath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd, dane nie zostały wczytane");
            return null;
        }
    }

    public List<Student> getStudentFromFile() {
        return getLinesFromFile().stream().map(line -> {
            String[] splitline = line.split(";");
            String pesel = splitline[0];
            String firstName = splitline[1];
            String lastName = splitline[2];
            Sex sex = Sex.valueOf(splitline[3]);
            String year = splitline[4];

            double finalGrade = Double.parseDouble(splitline[5]);

            Student student = new Student(pesel, firstName, lastName, sex, year, finalGrade);
            return student;

        }).collect(Collectors.toList());
    }
}
