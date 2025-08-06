public class Student extends User {
    private String course;
    private String year;

    public Student(String name, String email, String password, String course, String year) {
        super(name, email, password);
        this.course = course;
        this.year = year;
    }

    public String getDetails() {
        return "Student: " + name + ", Course: " + course + ", Year: " + year;
    }
}

