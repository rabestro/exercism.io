import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

class ProteinTranslator {
    private static final Pattern CODONS = Pattern.compile("(?<=\\G.{3})");

    private String codonToProtein(String codon) {
        switch (codon) {
            case "AUG":
                return "Methionine";
            case "UUU":
            case "UUC":
                return "Phenylalanine";
            case "UUA":
            case "UUG":
                return "Leucine";
            case "UCU":
            case "UCC":
            case "UCA":
            case "UCG":
                return "Serine";
            case "UAU":
            case "UAC":
                return "Tyrosine";
            case "UGU":
            case "UGC":
                return "Cysteine";
            case "UGG":
                return "Tryptophan";
            default:
                return "STOP";
        }
    }

    List<String> translate(String rnaSequence) {
        return CODONS.splitAsStream(rnaSequence)
                .map(this::codonToProtein)
                .takeWhile(not("STOP"::equals))
                .collect(Collectors.toList());
    }

}
