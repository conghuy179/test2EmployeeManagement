import Models.EmployeeManagement;

import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final EmployeeManagement em = new EmployeeManagement();
    public static void main(String[] args) {
        Driver driver = new Driver(sc, em);
        driver.run();
    }
}