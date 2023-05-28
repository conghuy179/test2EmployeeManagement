package Models;

public class Fresher extends Candidate {
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(String familyName, String lastName, int yob, String address, String phoneNumber, String email, String type) {
        super(familyName, lastName, yob, address, phoneNumber, email, type);
    }

    public Fresher(int yob, String phoneNumber, String email, String graduationRank) {
        super(yob, phoneNumber, email);
        this.graduationRank = graduationRank;
    }

    public Fresher(int yob, String phoneNumber, String email) {
        super();
    }

    public String getType() {
        return "Models.Fresher";
    }
}
