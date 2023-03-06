import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Stream.iterate;

class SimpleLinkedList<T> {
    private Node<T> head;

    SimpleLinkedList() {
    }

    SimpleLinkedList(T[] values) {
        Arrays.stream(values).forEach(this::push);
    }

    void push(T element) {
        head = new Node<>(element, head);
    }

    T pop() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        var element = head.data;
        head = head.next;
        return element;
    }

    void reverse() {
        var nodes = stream(head);
        head = null;
        nodes.map(Node::data).forEach(this::push);
    }

    Stream<Node<T>> stream(Node<T> first) {
        return iterate(first, Objects::nonNull, Node::next);
    }

    Stream<Node<T>> stream() {
        return stream(head);
    }

    @SuppressWarnings("unchecked")
    T[] asArray(Class<T> clazz) {
        return (T[]) stream().map(Node::data).toArray();
    }

    int size() {
        return (int) stream().count();
    }

    record Node<T>(T data, Node<T> next) {
    }
}
