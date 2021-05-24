package sample;

import java.time.LocalDate;
import java.util.ArrayList;

public class Holidays {
    private ArrayList<LocalDate> holidays;

    public Holidays() {
        // The constructor
        this.holidays = new ArrayList<LocalDate>();
    }
    public void addHoliday(LocalDate holiday) {
        // add a holiday to the list of holidays - only if it is not in the list already
        if (! this.holidays.contains(holiday)) {this.holidays.add(holiday);}
    }
    public void removeHoliday(LocalDate holiday) {
        // remove a holiday from the list of holidays - only if it is in the list already
        if (this.holidays.contains(holiday)) {this.holidays.remove(holiday);}
    }

    public ArrayList<LocalDate> getHolidays() { // return a list of holidays
        return holidays;
    }

    public Boolean containsDay(LocalDate holiday) { // Check of the date in in the list of holidays

        return this.holidays.contains(holiday);
    }

    public void printHolidays() {
        System.out.println("Number of holidays: " + this.holidays.size());
            for (LocalDate d : this.holidays) {
                System.out.println(d);
        }

    }

    public Integer getSize() { // Return the number of holidays in the holidays list
        return this.holidays.size();
    }
}

