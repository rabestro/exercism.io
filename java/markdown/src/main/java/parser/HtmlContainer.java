package parser;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import static java.util.function.Predicate.not;

public class HtmlContainer implements Supplier<String> {
    private static final Predicate<String> LIST_ITEM_MATCHER = Pattern.compile("(<li>).*").asMatchPredicate();
    private static final Predicate<String> HEADER_MATCHER = Pattern.compile("(<h).*").asMatchPredicate();
    private static final Predicate<String> PARAGRAPH_MATCHER = Pattern.compile("(<p>).*").asMatchPredicate();
    private static final Predicate<String> LIST_MATCHER =
            LIST_ITEM_MATCHER.and(not(PARAGRAPH_MATCHER)).and(not(HEADER_MATCHER));
    private final StringBuilder result;
    private boolean activeList;

    public HtmlContainer() {
        this.result = new StringBuilder();
    }

    private boolean shouldStartList(String line) {
        return !activeList && LIST_MATCHER.test(line);
    }

    private void startList() {
        activeList = true;
        result.append("<ul>");
    }

    private boolean shouldEndList(String line) {
        return activeList && not(LIST_ITEM_MATCHER).test(line);
    }

    private void endList() {
        activeList = false;
        result.append("</ul>");
    }

    void append(String line) {
        if (shouldStartList(line)) {
            startList();
        } else if (shouldEndList(line)) {
            endList();
        }
        result.append(line);
    }

    @Override
    public String get() {
        if (activeList) {
            result.append("</ul>");
        }
        activeList = false;
        return result.toString();
    }

    public HtmlContainer merge(HtmlContainer htmlContainer) {
        throw new UnsupportedOperationException("Parallel processing is not supported.");
    }
}
