package sample;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;
    private Holidays holidays;

    public Holidays getHolidays() {
        return holidays;
    }

    public void setHolidays(Holidays holidays) {
        this.holidays = holidays;
    }



    public Employee(String firstName, String lastName, String employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;

    }

    public String checkAvailable(Clinic clinic, LocalDate bookingDate){
        String bookingDateAsString=bookingDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (clinic.getHolidays().containsDay(bookingDate)) {
            return ("The clinic is closed on " +  bookingDateAsString);
        } else if (!(this.holidays==null) && this.holidays.containsDay(bookingDate)) {
            return("Employee is on holiday on " + bookingDateAsString);
        } else {
            return("Employee is available on " + bookingDateAsString);
        }
    };

    public void printHolidays() {
        if (this.holidays != null) {
            System.out.println("Number of holidays: " + this.holidays.getSize());
            if (this.holidays.getSize() > 0) {
                for (LocalDate d : this.holidays.getHolidays()) {
                    System.out.println(d);
                }
            }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

}
