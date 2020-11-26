import static java.util.Objects.isNull;

public class DoublyLinkedList<T> {
    private Box<T> head;
    private Box<T> tail;

    public void push(T data) {
        final var box = new Box<>(data);

        if (isNull(head)) {
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
        if (isNull(tail)) {
            head  = null;
        }
        return box.getData();
    }

    public T shift() {
        return null;
    }

    public void unshift(T c) {

    }

    private static class Box<T> {
        private Box<T> prev;
        private Box<T> next;
        private T data;

        public Box(T data) {
            this.data = data;
        }

        public void setNext(Box<T> element) {
            next = element;
        }

        public void setPrev(Box<T> element) {
            prev = element;
        }

        public Box<T> getPrev() {
            return prev;
        }

        public T getData() {
            return data;
        }
    }
}