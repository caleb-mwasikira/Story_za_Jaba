package University;

import java.util.ArrayList;
import java.util.Collection;

public class Student {
    public String registrationNumber;
    public String name;
    public String course;
    protected double feeBalance;
    private Collection<String> units;

    private static int REG_NUM_LENGTH = 12;

    public Student(String name, String course) {
        this.registrationNumber = generateRegistrationNumber();
        this.name = name;
        this.course = course;
        this.feeBalance = 0.0;
        this.units = new ArrayList<String>();
    }

    public double getFeeBalance() {
        return this.feeBalance;
    }

    public Collection<String> getUnits() {
        return this.units;
    }

    /**
     * Function to generate a random string of length n
     */
    private String generateRegistrationNumber() {
        // choose a Character random from this String
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of alphaNumericString
        StringBuilder buffer = new StringBuilder(Student.REG_NUM_LENGTH);

        for (int i = 0; i < Student.REG_NUM_LENGTH; i++) {
            // generate a random number between
            // 0 to alphaNumericString variable length
            int index
                    = (int) (alphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of buffer
            buffer.append(alphaNumericString
                    .charAt(index));
        }

        return buffer.toString();
    }

    public void printStudentDetails() {
        System.out.println("Student: " + this.name);
        System.out.println("Registration Number: " + this.registrationNumber);
        System.out.println("Course: " + this.course);
        System.out.println("Fee Balance: " + this.feeBalance);
        System.out.println("Units: " + this.units);
    }

    public void registerUnits(Collection<String> units) {
        System.out.println("Registering units...");

        this.units.addAll(units);
        this.feeBalance = 7_000 * units.size();

    }

    public boolean payFees(double amount) {
        System.out.println("Paying fees of amount " + amount);

        if(amount <= 0) {
            System.out.println("Failed to pay fees. Invalid fee amount");
            return false;
        }

        this.feeBalance -= amount;
        return true;
    }

    public void dropUnits(Collection<String> units) {
        System.out.println("Dropped the following units: " + units);

        for (String unit:units) {
            this.units.remove(unit);
        }
    }

    public void changeCourse(String newCourse) {
        this.course = newCourse;
        System.out.println("You have changed course. Now taking " + this.course);
    }
}
