import java.util.*;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class Lists 
{

    public static void main(String[] args) 
    {
        Set<String> hash = new HashSet<String>();
        Set<String> tree = new TreeSet<String>();
        Set<String> link = new LinkedHashSet<String>();
        for (String a : args)
        {
            hash.add(a);
            tree.add(a);
            link.add(a);
            System.out.println(a);
        }
        System.out.println("HashSet       " +hash+" unordered");
        System.out.println("TreeSet       " +tree+" ordered");
        System.out.println("LinkedHashSet " +link+" insertion order");

        List<String> list = Arrays.asList(args);
        System.out.println("Arrays        " +link+" sequence");

        List<String> list2 = Arrays.asList(args);
        Collections.shuffle(list2);

        System.out.println("Random list   "+list);
    }

    public static <E> void swap(List<E> a, int i, int j) 
    {
        E tmp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, tmp);
    }

    public static void shuffle(List<?> list, Random rnd) 
    {
        for (int i = list.size(); i > 1; i--)
            swap(list, i - 1, rnd.nextInt(i));
    }

    public static List reverse(List list)
    {
        List<String> list2 = new ArrayList<>();
        for (ListIterator<Type> it = list.listIterator(list.size()); it.hasPrevious(); ) 
        {
            Type t = it.previous();
            list2.add(t);
        }
        return list2;
    }

    public int indexOf(E e) 
    {
        for (ListIterator<E> it = listIterator(); it.hasNext(); )
            if (e == null ? it.next() == null : e.equals(it.next()))
                return it.previousIndex();
            // Element not found
        return -1;
    }

    /*
    The only bit of trickiness in this example is the equality test 
    between val and it.next. You need to special-case a val value of 
    null to prevent a NullPointerException.
    */
    public static <E> void replace(List<E> list, E val, E newVal) 
    {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
            if (val == null ? it.next() == null : val.equals(it.next()))
                it.set(newVal);
    }

    public static <E> 
        void replace(List<E> list, E val, List<? extends E> newVals) {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); ){
            if (val == null ? it.next() == null : val.equals(it.next())) {
                it.remove();
                for (E e : newVals)
                    it.add(e);
            }
        }
    }

    public static <E> 
        void replace2(List<E> list, E val, 
            List<? extends E> newVals) 
    {
        for (ListIterator<E> it = list.listIterator(); it.hasNext(); )
        {
            if (val == null ? it.next() == null : val.equals(it.next())) 
            {
                it.remove();
                for (E e : newVals)
                    it.add(e);
            }
        }
    }
    public static <E> List<E> dealHand(List<E> deck, int n) 
    {
        int deckSize = deck.size();
        List<E> handView = deck.subList(deckSize - n, deckSize);
        List<E> hand = new ArrayList<E>(handView);
        handView.clear();
        return hand;
    }

}