import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

class Gigasecond {
    static def GIGA_SECOND = Duration.ofSeconds(1_000_000_000)

    LocalDateTime moment

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
