import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Portal portal = new Portal();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n🎓 Student-Alumni Network Portal");
            System.out.println("1. Register as Student");
            System.out.println("2. Register as Alumni");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Email: ");
                    String sEmail = sc.nextLine();
                    System.out.print("Password: ");
                    String sPass = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    System.out.print("Year: ");
                    String year = sc.nextLine();
                    portal.registerStudent(sName, sEmail, sPass, course, year);
                    break;

                case 2:
                    System.out.print("Name: ");
                    String aName = sc.nextLine();
                    System.out.print("Email: ");
                    String aEmail = sc.nextLine();
                    System.out.print("Password: ");
                    String aPass = sc.nextLine();
                    System.out.print("Company: ");
                    String company = sc.nextLine();
                    System.out.print("Graduation Year: ");
                    String gradYear = sc.nextLine();
                    portal.registerAlumni(aName, aEmail, aPass, company, gradYear);
                    break;

                case 3:
                    System.out.print("Email: ");
                    String lEmail = sc.nextLine();
                    System.out.print("Password: ");
                    String lPass = sc.nextLine();
                    User user = portal.login(lEmail, lPass);

                    if (user == null) {
                        System.out.println("❌ Invalid credentials.");
                    } else {
                        System.out.println("✅ Logged in as " + user.getName());
                        if (user instanceof Student) {
                            boolean loggedIn = true;
                            while (loggedIn) {
                                System.out.println("\n1. View Alumni Directory\n2. Send Message to Alumni\n3. Logout");
                                int opt = sc.nextInt();
                                sc.nextLine();
                                if (opt == 1) portal.viewAlumniDirectory();
                                else if (opt == 2) {
                                    System.out.print("Enter message: ");
                                    String msg = sc.nextLine();
                                    portal.messageAlumni(user.getName(), msg);
                                } else loggedIn = false;
                            }
                        } else {
                            System.out.println("Welcome, Alumni! (Read-only access)");
                        }
                    }
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("❗ Invalid choice.");
            }
        }

        sc.close();
    }
}
