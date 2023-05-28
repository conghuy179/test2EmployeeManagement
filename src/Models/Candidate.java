package Models;

import java.util.UUID;

public class Candidate {
    private String id;
    private String familyName;
    private String lastName;
    private int yob;
    private String address;
    private String phoneNumber;
    private String email;
    private String type;

    public Candidate(String familyName, String lastName, int yob, String address, String phoneNumber, String email, String type) {
        this.id = String.valueOf(UUID.randomUUID());
        this.familyName = familyName;
        this.lastName = lastName;
        this.yob = yob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Candidate() {
        
    }

    public Candidate(int yob, String phoneNumber, String email) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
