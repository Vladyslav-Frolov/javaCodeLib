package info.vladyslav.javabasics.u01core.core_13_date_time;

import java.util.Calendar;

public class DifferenceInDaysOfDates {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        calendar1.set(2020, Calendar.DECEMBER, 31);
        calendar2.set(2021, Calendar.SEPTEMBER, 13);

        int diff = dateFiff(calendar2, calendar1);
        System.out.println(diff);
    }

    public static int dateFiff(Calendar date1, Calendar date2) {
        if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
            return Math.abs(date1.get(Calendar.DAY_OF_YEAR) - date2.get(Calendar.DAY_OF_YEAR));
        } else {
            if (date2.get(Calendar.YEAR) > date1.get(Calendar.YEAR)) {
                Calendar temp = date1;
                date1 = date2;
                date2 = temp;
            }
            int resultDays = 0;
            int dayOneOriginalYearDays = date1.get(Calendar.DAY_OF_YEAR);
            while (date1.get(Calendar.YEAR) > date2.get(Calendar.YEAR)) {
                date1.add(Calendar.YEAR, -1);
                resultDays += date1.getActualMaximum(Calendar.DAY_OF_YEAR);
            }
            return resultDays - date2.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays;
        }
    }
}
