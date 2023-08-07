package parser;

import java.util.function.Function;
import java.util.stream.Collector;

public class MarkdownParser implements Parser {
    private final Function<String, Function<String, String>> parserFactory = new ParserFactory();

    @Override
    public String apply(String text) {
        return text.lines()
                .map(this::parseLine)
                .collect(Collector.of(
                        HtmlContainer::new,
                        HtmlContainer::append,
                        HtmlContainer::merge,
                        HtmlContainer::get
                ));
    }

    private String parseLine(String line) {
        var parser = parserFactory.apply(line);
        return parser.apply(line);
    }
}
