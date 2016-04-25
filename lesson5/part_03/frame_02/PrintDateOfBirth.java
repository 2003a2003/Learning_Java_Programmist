package lesson5.part_03.frame_02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrintDateOfBirth {

    public static void main(String[] args) throws ParseException {

        String myDateOfBirth = "03.10.1978";
        SimpleDateFormat formatToParrce = new SimpleDateFormat("dd.MM.yyyy");
        Date d = formatToParrce.parse(myDateOfBirth);
        SimpleDateFormat myBirthDay = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        System.out.println("Date of Birth: " + myBirthDay.format(d));

    }
}
