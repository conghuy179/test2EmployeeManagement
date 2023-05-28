import Models.Candidate;
import Models.EmployeeManagement;
import Models.ExperiencedCandidate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Driver {
    private static final int CHOICE_CREATE_EXP_CAN = 1;
    private static final int CHOICE_CREATE_FRESHER = 2;
    private static final int CHOICE_CREATE_INTERN = 3;
    private static final int CHOICE_SEARCH = 4;
    private static final int CHOICE_EXIT = 5;
    private Scanner sc;
    private int selection;
    private EmployeeManagement em;

    public Driver(Scanner sc, EmployeeManagement em) {
        this.em = em;
        this.sc = sc.useDelimiter("\n");
    }

    public void printMenu() {
        System.out.println("HE THONG QUAN LY UNG VIEN");
        System.out.println("1. Co kinh nghiem");
        System.out.println("2. Fresher");
        System.out.println("3. Thuc tap sinh");
        System.out.println("4. Dang tim kiem");
        System.out.println("5. Thoat");
        System.out.println("Vui long chon 1 de tao ung vien cho kinh nghiem, 2 de tao Models.Fresher,");
        System.out.println("3 cho ung vien thuc tap sinh, 4 de tim kiem va 5 de thoat chuong trinh.");
        System.out.println("Nhap lua chon cua ban: ");
    }

    public void run() {
        String selectionText;
        do {
            printMenu();
            try {
                selectionText = sc.next();
                isValidSelection(selectionText);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                continue;
            }

            selection = Integer.parseInt(selectionText);
            if (selection == CHOICE_CREATE_EXP_CAN) {
                runCreateExpCandidate();
            } else if (selection == CHOICE_CREATE_FRESHER) {
                runCreateFresher();
            } else if (selection == CHOICE_CREATE_INTERN) {
                runCreateIntern();
            } else if (selection == CHOICE_SEARCH) {
                runSearch();
            }
        } while (selection != CHOICE_EXIT);
    }

    private void runCreateExpCandidate() {
        int yob = -1;
        String phoneNumber;
        String email;
        int expInYear = -1;
        String graduationRank;

        // input year of Birth and check validation
        do {
            String yearOfBirth;
            System.out.println("Nhap nam sinh ung vien: ");
            try {
                yearOfBirth = sc.next();
                isYearOfBirthValid(yearOfBirth);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            yob = Integer.parseInt(yearOfBirth);
            if (!isYobValid(yob)) {
                System.out.println("Nam sinh khong hop le. Yeu cau nhap trong khoang 1923 -> 2013.");
            }
        } while (!isYobValid(yob));

        // input phoneNumber and check validation
        do {
            System.out.println("Nhap so dien thoai ung vien: ");
            phoneNumber = sc.next();
            if (!isPhoneNumberValid(phoneNumber)) {
                System.out.println("So dien thoai gom it nhat 10 ky tu va chi co so. Yeu cau nhap lai.");
            }
        } while (!isPhoneNumberValid(phoneNumber));

        // input email and check validation
        do {
            System.out.println("Nhap email ");
            email = sc.next();
            if (!isEmailValid(email)) {
                System.out.println("Email co cu phap \"tentaikhoan@tenmien\" . Yeu cau nhap lai.");
            }
        } while (!isEmailValid(email));

        //Input Year of Exp and check validation
        do {
            String yearOfExp;
            System.out.println("Nhap so nam kinh nghiem.");
            try {
                yearOfExp = sc.next();
                isYearOfExpValid(yearOfExp);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            expInYear = Integer.parseInt(yearOfExp);
            if (!isYoEValid(expInYear)) {
                System.out.println("Chi nhap so nam kinh nghiem tu 0 den 100.");
                System.out.println("Yeu cau nhap lai.");
            }
        } while (!isYoEValid(expInYear));

        // Input rank of graduation and check validation
        do {
            System.out.println("Nhap loai tot nghiep: (Xuat sac, Tot, Kha, Kem).");
            graduationRank = sc.next();
            graduationRank = convertGRank(graduationRank);
            if (!isGraduationRankValid(graduationRank)) {
                System.out.println("loai tot nghiep phai thuoc 1 trong 4 loai: Xuat sac, Tot, Kha, Kem.");
                System.out.println("Yeu cau nhap lai.");
            }
        } while (!isGraduationRankValid(graduationRank));

        // Thoa man tat ca dieu kien thi tao ung vien
        em.addCan(new ExperiencedCandidate(yob, phoneNumber, email, expInYear, graduationRank));
    }


    public boolean isYearOfBirthValid(String yearOfBirth) {
        boolean isValid = false;
        if (yearOfBirth.length() != 4) {
            throw new IllegalArgumentException("Chi nhap so nam tu 1923 den 2013. Yeu cau nhap lai.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    public boolean isYobValid(int yob) {
        if (yob < 1923 || yob > 2013) {
            return false;
        }
        return true;
    }

    public boolean isEmailValid(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.length() < 10) {
            return false;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public boolean isYoEValid(int expInYear) {
        if (expInYear < 0 || expInYear > 100) {
            return false;
        }
        return true;
    }

    public boolean isYearOfExpValid(String yearOfExp) {
        boolean isValid = false;
        if (Integer.parseInt(yearOfExp) < 0 || Integer.parseInt(yearOfExp) > 100) {
            System.out.println("Chi nhap so nam kinh nghiem tu 0 den 100.");
        } else {
            isValid = true;
        }
        return isValid;
    }

    public String convertGRank(String graduationRank) {
        String correctGraduationRank = null;
        if (graduationRank.equals("xuat sac")
                || graduationRank.equals("Xuat Sac")
                || graduationRank.equals("XUAT SAC")) {
            correctGraduationRank = "Xuat sac";
        } else if (graduationRank.equals("tot")
                || graduationRank.equals("TOT")
                || graduationRank.equals("TOt")
                || graduationRank.equals("tOT")) {
            correctGraduationRank = "Tot";
        } else if (graduationRank.equals("KHA")
                || graduationRank.equals("kha")
                || graduationRank.equals("kHA")
                || graduationRank.equals("KHa")) {
            correctGraduationRank = "Kha";
        } else if (graduationRank.equals("KEM")
                || graduationRank.equals("kem")
                || graduationRank.equals("KEm")
                || graduationRank.equals("kEM")
                || graduationRank.equals("KeM")) {
            correctGraduationRank = "Kem";
        } else if (graduationRank.equals("Xuat sac")
                || graduationRank.equals("Tot")
                || graduationRank.equals("Kha")
                || graduationRank.equals("Kem")) {
            return graduationRank;
        }
        return correctGraduationRank;
    }

    public boolean isGraduationRankValid(String graduationRank) {
        boolean result = true;

        if (!graduationRank.equals("Xuat sac")
                && !graduationRank.equals("Tot")
                && !graduationRank.equals("Kha")
                && !graduationRank.equals("Kem")) {
            return false;
        }
        return true;
    }


    private void runCreateFresher() {

    }

    private void runCreateIntern() {

    }

    private void runSearch() {
    }

    public static boolean isValidSelection(String selection) {
        boolean isDigit = false;
        if (selection.length() > 1) {
            throw new IllegalArgumentException("Chi nhap 1 so tu 1 den 5.");
        } else if (selection.charAt(0) < '1' || selection.charAt(0) > '5') {
            throw new IllegalArgumentException("Chi nhap 1 so trong khoang tu 1 den 5");
        } else {
            isDigit = true;
        }
        return isDigit;
    }
}
