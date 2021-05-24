package sample;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Patient {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String cpr;

    public Patient(String firstName, String lastName, String inputCPR) {
        // assign the inputName to the field storing the patient's name. (replace the ??? with the field your created earlier)
        this.firstName = firstName;
        this.lastName = lastName;

        // assign the inputCPR to the field storing the patient's CPR-number. (replace the ??? with the field your created earlier)
        this.cpr = inputCPR;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public int getAge () {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuu");
        LocalDate today = LocalDate.now();
        LocalDate birthdate = LocalDate.parse(cpr.substring(0,6), dateFormatter);
        // If the birthdate is after today, it's probably in the 1900's. Subtract 100 years.
        if (birthdate.isAfter(today)) { birthdate = birthdate.minusYears(100); }
        int age = Period.between(birthdate, today).getYears();
        return age;
    }
    public String getGender() {
        String serial = cpr.substring(7,11);
        if (Integer.parseInt(serial) % 2 == 0) {
            return "Female";
        } else {
            return "Male";
        }
    }
    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cpr='" + cpr + '\'' +
                '}';
    }
}
