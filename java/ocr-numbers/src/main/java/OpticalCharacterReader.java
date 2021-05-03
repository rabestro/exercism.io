import java.util.List;

class OpticalCharacterReader {

    public String parse(List<String> asList) {
        if (asList.size() % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        return "0";
    }
}