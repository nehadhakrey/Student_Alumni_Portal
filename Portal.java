import java.util.*;

public class Portal {
    private List<Student> students = new ArrayList<>();
    private List<Alumni> alumni = new ArrayList<>();

    public void registerStudent(String name, String email, String password, String course, String year) {
        students.add(new Student(name, email, password, course, year));
        System.out.println("✅ Student registered successfully!");
    }

    public void registerAlumni(String name, String email, String password, String company, String gradYear) {
        alumni.add(new Alumni(name, email, password, company, gradYear));
        System.out.println("✅ Alumni registered successfully!");
    }

    public User login(String email, String password) {
        for (Student s : students) {
            if (s.login(email, password)) return s;
        }
        for (Alumni a : alumni) {
            if (a.login(email, password)) return a;
        }
        return null;
    }

    public void viewAlumniDirectory() {
        System.out.println("📚 Alumni Directory:");
        for (Alumni a : alumni) {
            System.out.println("- " + a.getDetails());
        }
    }

    public void messageAlumni(String studentName, String message) {
        System.out.println("\n📨 Message from " + studentName + ": " + message);
        System.out.println("Message sent to alumni.\n");
    }
}

