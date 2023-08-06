import parser.MarkdownParser;

class Markdown {
    String parse(String markdown) {
        return new MarkdownParser().apply(markdown);
    }
}
