import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Stream.iterate;

class SimpleLinkedList<T> {
    private Node<T> head;

    SimpleLinkedList() {
        head = new Node<>(null);
    }

    SimpleLinkedList(T[] values) {
        this();
        Arrays.stream(values).forEach(this::push);
    }

    void push(T element) {
        head.data = element;
        head = new Node<>(head);
    }

    T pop() {
        if (head.next == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        return head.data;
    }

    void reverse() {
        var reverse = head.next;
        head = new Node<>(null);
        iterate(reverse, Objects::nonNull, e -> e.next)
                .map(e -> e.data)
                .forEach(this::push);
    }

    Stream<Node<T>> stream() {
        return iterate(head.next, Objects::nonNull, e -> e.next);
    }

    @SuppressWarnings("unchecked")
    T[] asArray(Class<T> clazz) {
        return (T[]) stream().map(e -> e.data).toArray();
    }

    int size() {
        return (int) stream().count();
    }

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(Node<T> next) {
            this.next = next;
        }
    }
}
