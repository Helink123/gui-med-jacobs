package sample;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    // Class used to check if input data is valid

    public static boolean isValidDate(String dateString) {
        Boolean result = false;

        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate b = LocalDate.parse(dateString, dateFormatter);
            return true;
        }
        catch (DateTimeParseException dtpe) {
            System.err.println("Illegal date:"+dateString);
            return false;
        }

    }
    public static boolean isValidCPR(String cpr) {
        Boolean result = false;
        // Check the lenght
        if (cpr.length() == 11) {
            result = true;
        } else {
            return false;
        }

        // Check the format (two numbers)
        // first split the cpr number
        String birthday = cpr.substring(0,6);
        Character hyphen = cpr.charAt(6);
        String lastNumber = cpr.substring(7,11);
        try { // test if the first part is a number }
            int d = Integer.parseInt(birthday);
        } catch (NumberFormatException nfe) {
            System.out.println("First part is not a number");
            return false;
        }
        if (! hyphen.equals('-')) {
            System.out.println("Missing hyphen");
            return false; };
        try { // test if the last part is a number }
            int running = Integer.parseInt(lastNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("Last part is not a number");
            return false;
        }

        // a much easier approach with regex
        // and the extract the first and last part..
        if (cpr.matches("^[0-9]{6}-[0-9]{4}$")) {
            System.out.println("matches regex");
            result = true;

        } else {
            result = false;
        }

        // now test the date using LocalDate
        try {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("ddMMuu");
            LocalDate b = LocalDate.parse(birthday, dateFormatter);
        }
        catch (DateTimeParseException dtpe) {
            System.err.println("Illegal birthday:"+birthday.toString());
            return false;
        }

        return result;
    }
    public static boolean isValidName(String name) {
        // Sorry Marie-Louise.... '-' not allowed in this stupid validator

        if (name.length() > 1 &&
            name.chars().allMatch(Character::isAlphabetic)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        // https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s03.html
        final String EMAIL_PATTERN =
                "^(?=.{1,64}@)[\\p{L}0-9_-]+(\\.[\\p{L}0-9_-]+)*@"
                        + "[^-][\\p{L}0-9-]+(\\.[\\p{L}0-9-]+)*(\\.[\\p{L}]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        final String PHONE_PATTERN =
                "^\\+(?:[0-9] ?){6,14}[0-9]$";

        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


    public boolean isValidAddress(String address) {
        return false;
    }


}
