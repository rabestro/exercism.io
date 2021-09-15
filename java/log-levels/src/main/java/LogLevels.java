public class LogLevels {

    public static String message(String logLine) {
        return parse(logLine)[1];
    }

    public static String logLevel(String logLine) {
        return parse(logLine)[0];
    }

    public static String reformat(String logLine) {
        return String.format("%2$s (%1$s)", (Object[]) parse(logLine));
    }

    private static String[] parse(String log) {
        int index = log.indexOf(']');
        return new String[]{log.substring(1, index).toLowerCase(), log.substring(index + 2).strip()};
    }
}
