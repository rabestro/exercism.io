import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

class ProteinTranslator {
    private static final Pattern SEQUENCE_SPLITTER = Pattern.compile("(?<=\\G.{3})");
    private static final Map<String, String> TRANSLATION = new HashMap<>();

    private static void loadTranslation(String protein, String... codons) {
        for (String codon : codons) {
            TRANSLATION.put(codon, protein);
        }
    }

    static {
        loadTranslation("Methionine", "AUG");
        loadTranslation("Phenylalanine", "UUU", "UUC");
        loadTranslation("Leucine", "UUA", "UUG");
        loadTranslation("Serine", "UCU", "UCC", "UCA", "UCG");
        loadTranslation("Tyrosine", "UAU", "UAC");
        loadTranslation("Cysteine", "UGU", "UGC");
        loadTranslation("Tryptophan", "UGG");
        loadTranslation("STOP", "UAA", "UAG", "UGA");
    }

    List<String> translate(String rnaSequence) {
        return SEQUENCE_SPLITTER.splitAsStream(rnaSequence)
                .map(TRANSLATION::get)
                .takeWhile(not("STOP"::equals))
                .collect(Collectors.toList());
    }

}
