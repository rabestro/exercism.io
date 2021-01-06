import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Gigasecond {
    private static final long GIGASECOND = 1_000_000_000;

    private final LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plusSeconds(GIGASECOND);
    }

    public LocalDateTime getDateTime() {
        return moment;
    }
}
