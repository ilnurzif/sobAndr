import java.util.ListIterator;

public class VectorList<E> {
    private Node<E> node = null;
    private int counter = 0;
    private VectorListIterator vectorListIterator;

    public VectorList() {
        node = new Node<>();
    }

    public int size() {
        return counter;
    }

    public void add(E element) {
        if (counter == 0) {    // первый узел надо обработать отдельно, иначе в первом узле элемент будет балластом
            node.set(element);
        } else {
            node.add(element);
        }
        counter++;             // увеличим счетчик элементов
    }

    private Node<E> getCurrentNode() {
        return node;
    }

    public ListIterator getListIterator() {
        vectorListIterator = new VectorListIterator(node);
        return vectorListIterator;
    }

// Узел с элементом, сделан внутренним, чтобы не светить его наружу
    private class Node<E> {
        private E element;
        private Node<E> next = null;
        private Node<E> prev = null;

        Node() {
        }

        Node(E element) {
            set(element);
        }

        void set(E element) {
            this.element = element;
        }

        void add(E element) {
            if (isNext()) {                      // если существует следующий узел, передадим ему эстафету
                next.add(element);
            } else {                               // иначе создадим следующий узел
                next = new Node<>(element);
                next.prev = this;
            }
        }

        E get() {
            return element;
        }

        boolean isNext() {
            return next != null;
        }

        boolean isPrevios() {
            return prev != null;
        }
    }

    // Итератор, светить наружу его тоже не хочется, он слишком специфичный.
    public class VectorListIterator implements ListIterator<E> {
        private Node<E> current;
        private boolean isFirst = true;     // первый узел надо обработать отдельно
        private boolean isLast = true;

        VectorListIterator(Node<E> node) {
            current = node;
        }

        @Override
        public boolean hasNext() {
            if (counter == 1 && isFirst) return true;   // отдельно обработать один элемент (потому как у него нет next)
            return current.isNext();
        }

        @Override
        public E next() {
            if (isFirst) isFirst = false;
            else current = current.next;
            return current.get();
        }

        @Override
        public boolean hasPrevious() {
            return current.isPrevios();
        }

        @Override
        public E previous() {
            if (isLast) isLast = false;
            else current = current.prev;
            return current.get();
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }
}
