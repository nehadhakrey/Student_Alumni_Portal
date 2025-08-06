public class Alumni extends User {
    private String company;
    private String graduationYear;

    public Alumni(String name, String email, String password, String company, String graduationYear) {
        super(name, email, password);
        this.company = company;
        this.graduationYear = graduationYear;
    }

    public String getDetails() {
        return "Alumni: " + name + ", Company: " + company + ", Graduated: " + graduationYear;
    }
}

