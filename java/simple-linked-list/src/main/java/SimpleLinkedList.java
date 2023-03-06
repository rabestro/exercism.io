import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

final class SimpleLinkedList<T> {
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
        var nodes = stream();
        head = null;
        nodes.forEach(this::push);
    }

    Stream<T> stream() {
        return Stream.iterate(head, Objects::nonNull, Node::next).map(Node::data);
    }

    @SuppressWarnings({"unchecked", "unused"})
    T[] asArray(Class<T> clazz) {
        return (T[]) stream().toArray();
    }

    int size() {
        return (int) stream().count();
    }

    record Node<T>(T data, Node<T> next) {
    }
}
