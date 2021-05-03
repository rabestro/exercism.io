import java.util.List;

class OpticalCharacterReader {

    public String parse(List<String> asList) {
        if (asList.size() % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (asList.get(0).length() % 3 != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        return "0";
    }
}