import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example2 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings,Integer.valueOf(42));
//        String s = strings.get(0);

        //Simple program to exercise generic method
        Set<String> guys = Set.of("Tom","Dick","Harry");
        Set<String> stooges = Set.of("Larry","Moe","Curly");
        Set<String> aflCio = union(guys,stooges);
        System.out.println(aflCio);
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    public static <E> Set<E> union(Set<E> s1,Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}

