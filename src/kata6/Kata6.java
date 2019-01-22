package kata6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;

public class Kata6 {
    
    private static Iterator<Integer> mb (Iterator<Long> iterator){
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext(){
                return iterator.hasNext();
            }
            
            @Override
            public Integer next(){
                return (int)(iterator.next() / (1024*1024));
            }
        };
    }
    
    public static Iterator <Long> length(Iterator<File> iterator){
         return new Iterator<Long>(){
             @Override
             public boolean hasNext(){
                 return iterator.hasNext();
             }
             
             @Override
             public Long next(){
                 return iterator.next().length();
             }
         };
    }
    
    private static <T> Iterator <T> iteratorOf(T[] items){
        return new Iterator<T>(){
            private int x = 0;
                
            @Override
            public boolean hasNext(){
                return x<items.length;
            }
                
            @Override
            public T next(){
                return items[x++];
            }
        };
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/");
        Iterator<Integer> iterator = mb(length(iteratorOf(file.listFiles())));
        while(iterator.hasNext()) System.out.println(iterator.next());        
    }
    
}
