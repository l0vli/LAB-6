package it.unibo.collections;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int START = 1000;
    private final static int END = 2000;
    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

        List<Integer> vettore = new ArrayList<>();

        for(int i = START; i < END; i ++){
            vettore.add(i); 
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */

         List<Integer> vettore_2 = new ArrayList<>();
         vettore_2.addAll(0, vettore); // il secondo parametro è una collection <? extends integer>

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */

        int first_el = vettore.get(0);
        vettore.set(0, vettore.get(vettore.size() - 1) ); // ultimo elemento al posto del primo
        vettore.set(vettore.size() - 1, first_el); // primo elemento al posto dell'ultimo

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         

        for (int element : vettore ){
            System.out.println(element);
        }

        */
        
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        Map<Continent, Long > mondo = new HashMap<>();
        mondo.put(Continent.AFRICA, 1110635000L);
        mondo.put(Continent.AMERICA, 972005000L);
        mondo.put(Continent.ANTARTIDE, 0L);
        mondo.put(Continent.ASIA, 42987230000L);
        mondo.put(Continent.EUROPA, 742252000L);
        mondo.put(Continent.OCEANIA, 38304000L);

        /*
         * 8) Compute the population of the world
         */

         Iterator<Long> iter = mondo.values().iterator();
         Long population = 0L;

         while(iter.hasNext()){
            population += iter.next();
         }

         System.out.println("popolazione mondiale pari a : " + population + " persone");
    }
}
