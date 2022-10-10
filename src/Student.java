import java.util.Objects;

public class Student {
    private String pesel;

    private String firstName;
    private String lastName;
    private Sex sex;
    private String year;
    private double finalGrade;

    public Student(String pesel, String firstName, String lastName, Sex sex, String year, double finalGrade) {
        this.pesel = pesel;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.year = year;
        this.finalGrade = finalGrade;
    }

    public String getPesel() {
        return pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public String getYear() {
        return year;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Objects.equals(pesel, student.pesel);
    }

    @Override
    public int hashCode() {
        return pesel != null ? pesel.hashCode() : 0;
    }

    @Override
    public String toString() {
        return
                pesel + " " +
                        firstName + " " +
                        lastName + " " +
                        sex + " " +
                        year + " " +
                        finalGrade;

    }
}
