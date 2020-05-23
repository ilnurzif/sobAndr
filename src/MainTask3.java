import java.util.ListIterator;

public class MainTask3 {
    public static void main(String[] args) {
        VectorList<Integer> vectorList = new VectorList<>();
        vectorList.add(1);
        vectorList.add(4);
        vectorList.add(6);
        vectorList.add(4);

        ListIterator vectorIterator = vectorList.getListIterator();

        while (vectorIterator.hasNext()) {
            System.out.println(vectorIterator.next());
        }

        while (vectorIterator.hasPrevious()) {
            System.out.println(vectorIterator.previous());
        }
    }
}
