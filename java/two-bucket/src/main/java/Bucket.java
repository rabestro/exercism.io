enum Bucket {
    one, two;
    int cap;
    int volume;

    void fill() {
        volume = cap;
    }

    void empty() {
        volume = 0;
    }

    boolean isEmpty() {
        return volume == 0;
    }

    boolean isFull() {
        return volume == cap;
    }
}
