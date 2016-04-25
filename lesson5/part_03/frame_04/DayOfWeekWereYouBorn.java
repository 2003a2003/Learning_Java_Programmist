package lesson5.part_03.frame_04;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DayOfWeekWereYouBorn {
    public static void main(String[] args) throws ParseException {

        String myDateOfBirth = "03.10.1978";

        SimpleDateFormat formatToParrce = new SimpleDateFormat("dd.MM.yyyy");
        Date d = formatToParrce.parse(myDateOfBirth);

        SimpleDateFormat myBirthDay = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
        System.out.println("Date of my birth: " + myBirthDay.format(d));

        //Calendar
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        System.out.print("Day of week when i was born 1: ");
        System.out.println(c.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.ENGLISH));
        System.out.println();

        Calendar cal01 = new GregorianCalendar(1978,9,3);
        System.out.print("Day of week when i was born 2: ");
        System.out.print("#N: " + cal01.get(Calendar.DAY_OF_WEEK) + " it is ");
        System.out.println(cal01.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.ENGLISH));

    }
}
