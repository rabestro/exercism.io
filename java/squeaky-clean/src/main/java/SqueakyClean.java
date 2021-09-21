class SqueakyClean {
    static String clean(String identifier) {
        return identifier
                .replace(' ', '_')
                .replace("\0", "CTRL");
    }
}
