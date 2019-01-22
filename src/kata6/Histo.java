package kata6;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Histo <T> {
    private final Map<T,Integer> map = new HashMap<>();
    
    public Histo(Iterable<T> iterable){
        this(iterable.iterator());
    }
    
    public Histo (Iterator<T> iterator){
        while(iterator.hasNext()){
            add(iterator.next());
        }
    }

    private void add(T next) {
        map.put(next, get(next) + 1);
    }

    private int get(T next) {
        return map.containsKey(next) ? map.get(next) : 0;
    }
}
