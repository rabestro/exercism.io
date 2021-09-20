import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class ProteinTranslator {
    private static final Pattern CODONS = Pattern.compile(".{3}");
    private final Map<String, String> mapOfRna = Map.ofEntries(
            Map.entry("AUG", "Methionine"),
            Map.entry("UUU", "Phenylalanine"),
            Map.entry("UUC", "Phenylalanine"),
            Map.entry("UUA", "Leucine"),
            Map.entry("UUG", "Leucine"),
            Map.entry("UCU", "Serine"),
            Map.entry("UCC", "Serine"),
            Map.entry("UCA", "Serine"),
            Map.entry("UCG", "Serine"),
            Map.entry("UAU", "Tyrosine"),
            Map.entry("UAC", "Tyrosine"),
            Map.entry("UGU", "Cysteine"),
            Map.entry("UGC", "Cysteine"),
            Map.entry("UGG", "Tryptophan"),
            Map.entry("UAA", "STOP"),
            Map.entry("UGA", "STOP"),
            Map.entry("UAG", "STOP")
    );
    List<String> translate(String rnaSequence) {
        return CODONS.matcher(rnaSequence)
                .results()
                .map(MatchResult::group)
                .map(mapOfRna::get)
                .takeWhile(Predicate.not("STOP"::equals))
                .collect(Collectors.toList());
    }
}
