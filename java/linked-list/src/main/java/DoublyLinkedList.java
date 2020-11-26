public class DoublyLinkedList<T> {
    private Box<T> head;
    private Box<T> tail;

    public void push(T data) {
        final var box = new Box<>(data);

        if (head == null) {
            head = box;
            tail = head;
            return;
        }
        tail.setNext(box);
        box.setPrev(tail);
        tail = box;
    }

    public T pop() {
        if (tail == null) {
            return null;
        }
        final var box = tail;
        tail = tail.getPrev();
        if (tail == null) {
            head = null;
        }
        return box.getData();
    }

    public T shift() {
        if (head == null) {
            return null;
        }
        final var box = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return box.getData();
    }

    public void unshift(T data) {
        final var box = new Box<>(data);

        if (head == null) {
            head = box;
            tail = head;
            return;
        }
        head.setPrev(box);
        box.setNext(head);
        head = box;
    }

    private static class Box<T> {
        private Box<T> prev;
        private Box<T> next;
        private final T data;

        public Box(T data) {
            this.data = data;
        }

        public Box<T> getPrev() {
            return prev;
        }

        public void setPrev(Box<T> element) {
            prev = element;
        }

        public T getData() {
            return data;
        }

        public Box<T> getNext() {
            return next;
        }

        public void setNext(Box<T> element) {
            next = element;
        }
    }
}