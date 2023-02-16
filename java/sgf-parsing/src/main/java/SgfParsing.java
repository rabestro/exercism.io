import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class SgfParsing {

    public SgfNode parse(String input) throws SgfParsingException {
        var sgf = ValidSgf.from(input);
        return new SgfNode(sgf.properties());
    }

}

record ValidSgf(String top, String children) {
    private static Pattern SGF_NOTATION = Pattern.compile("""
            \\(;                    # First part of SGF-notation
            (?<top>                 # The top level node
                \\p{Lu}{1,2}            # A key must be in uppercase
                (\\[.+?(?<!\\\\)])+     # A key can have multiple values associated with it
            )+                      # The top level node may have several properties
            (?<children>.*)
            """, Pattern.COMMENTS);

    static ValidSgf from(String input) throws SgfParsingException {
        var matcher = SGF_NOTATION.matcher(input);
        if (!matcher.matches()) {
            throw new SgfParsingException("Invalid SGF format");
        }
        return new ValidSgf(matcher.group("top"), matcher.group("children"));
    }

    Map<String, List<String>> properties() {
        return new NodeParser().apply(top);
    }
}
