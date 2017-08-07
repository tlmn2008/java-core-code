package kenny.jconcurrent.concurrent_container.zzz_concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentHashMapTest {

    public static void main(String[] args){
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "kenny");

        System.out.println(map.get("1").equals("kenny"));

        ConcurrentLinkedDeque<String> list = new ConcurrentLinkedDeque<>();
        list.add("123");

    }
}
