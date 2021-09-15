import java.util.regex.Pattern;

public class LogLevels {

    public static String message(String logLine) {
        return new Log(logLine).message;
    }

    public static String logLevel(String logLine) {
        return new Log(logLine).level;
    }

    public static String reformat(String logLine) {
        final var log = new Log(logLine);
        return log.message + " (" + log.level + ")";
    }
}

class Log {
    private static final Pattern LOG_PATTERN =
            Pattern.compile("\\[(?<level>.+)]:\\s+(?<message>.+?)\\s*");
    String message;
    String level;

    Log(String logLine) {
        var matcher = LOG_PATTERN.matcher(logLine);
        if (matcher.matches()) {
            message = matcher.group("message");
            level = matcher.group("level").toLowerCase();
        } else {
            throw new IllegalArgumentException();
        }
    }
}