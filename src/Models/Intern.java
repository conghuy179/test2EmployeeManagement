package Models;

public class Intern extends Candidate{
    private String major;
    private String semester;
    private String uniName;

    public Intern(String id, String familyName, String lastName, int yob, String address, String phoneNumber, String email, String type) {
        super(id, familyName, lastName, yob, address, phoneNumber, email, type);
    }

    public String getType() {
        return "Models.Intern";
    }
}
