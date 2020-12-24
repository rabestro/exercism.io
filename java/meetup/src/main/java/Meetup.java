import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

class Meetup {
    private final int month;
    private final int year;
    private final YearMonth yearMonth;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
        yearMonth = YearMonth.of(year, month);
    }

    public LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule meetupSchedule) {
        LocalDate startDate = yearMonth.atDay(switch (meetupSchedule) {
            case FIRST -> 1;
            case SECOND -> 8;
            case THIRD -> 15;
            case FOURTH -> 22;
            case LAST -> yearMonth.lengthOfMonth() - 6;
            case TEENTH -> 13;
        });
        int offset = dayOfWeek.getValue() - startDate.getDayOfWeek().getValue();
        return startDate.plusDays(Math.floorMod(offset, 7));

    }
}