import java.util.List;
import java.util.regex.Pattern;

import static java.util.function.Predicate.not;

class ProteinTranslator {
    private static final Pattern CODONS = Pattern.compile("(?<=\\G.{3})");

    private String codonToProtein(String codon) {
        return switch (codon) {
            case "AUG" -> "Methionine";
            case "UUU", "UUC" -> "Phenylalanine";
            case "UUA", "UUG" -> "Leucine";
            case "UCU", "UCC", "UCA", "UCG" -> "Serine";
            case "UAU", "UAC" -> "Tyrosine";
            case "UGU", "UGC" -> "Cysteine";
            case "UGG" -> "Tryptophan";
            default -> "STOP";
        };
    }

    List<String> translate(String rnaSequence) {
        return CODONS.splitAsStream(rnaSequence)
                .map(this::codonToProtein)
                .takeWhile(not("STOP"::equals))
                .toList();
    }

}
