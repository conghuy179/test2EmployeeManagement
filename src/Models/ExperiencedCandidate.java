package Models;

public class ExperiencedCandidate extends Fresher {
    private int expInYear;
    private String proSkill;
    private String graduationRank;

    public ExperiencedCandidate(String familyName, String lastName, int yob, String address, String phoneNumber, String email, String type) {
        super(familyName, lastName, yob, address, phoneNumber, email, type);
    }
    public ExperiencedCandidate(int yob, String phoneNumber, String email, int expInYear, String graduationRank) {
        super(yob, phoneNumber, email);
        this.expInYear = expInYear;
        this.graduationRank = graduationRank;
    }

    public String getType() {
        return "Experienced Models.Candidate";
    }

}
