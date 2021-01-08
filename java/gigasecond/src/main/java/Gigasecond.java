import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private static final Duration GIGA_SECOND = Duration.ofSeconds(1_000_000_000);

    private final LocalDateTime moment;

    public Gigasecond(LocalDate moment) {
        this(moment.atStartOfDay());
    }

    public Gigasecond(LocalDateTime moment) {
        this.moment = moment.plus(GIGA_SECOND);
    }

    public LocalDateTime getDateTime() {
        return moment;
    }
}
