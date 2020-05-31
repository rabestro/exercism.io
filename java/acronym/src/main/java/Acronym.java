class Acronym {
    private final String acronym;

    Acronym(String phrase) {
        acronym = phrase.replace('-', ' ')
                .replaceAll("\\b_?(\\w)\\S* *", "$1").toUpperCase();
    }

    String get() {
        return acronym;
    }

}
