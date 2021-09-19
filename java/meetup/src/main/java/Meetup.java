import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class Meetup {
    private final int month;
    private final int year;

    public Meetup(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public LocalDate day(DayOfWeek day, MeetupSchedule teenth) {
        int startDay = 1;
        int skipDays = 0;
        UnaryOperator<LocalDate> nextDate = date -> date.plusDays(1);

        switch (teenth) {
            case FIRST, SECOND, THIRD, FOURTH -> skipDays = teenth.ordinal();
            case LAST -> {
                startDay = LocalDate.of(year, month, 1)
                        .with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
                nextDate = date -> date.plusDays(-1);
            }
            case TEENTH -> startDay = 13;
        }
        return Stream.iterate(LocalDate.of(year, month, startDay), nextDate)
                .filter(date -> date.getDayOfWeek() == day)
                .skip(skipDays)
                .findFirst().orElseThrow();
    }
}