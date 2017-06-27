package kenny.algorithm.container.map_container;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {

    public static void main(String[] args){

        Map<String, Integer> map = new HashMap();
        map.put("beijing ", 2500);
        map.put("shanghai", 2000);
        map.put("shenzhen", 1200);

        // keySet是 键 的集合，Set里面的类型即key的类型
        Iterator iterator1 = map.keySet().iterator();
        while(iterator1.hasNext()){
            Object key = iterator1.next();
            System.out.println("key:"+key+";  value:"+map.get(key));
        }

        // entrySet是 键值对 的集合，Set里面的类型是Map.Entry
        Iterator iterator2 = map.entrySet().iterator();
        while(iterator2.hasNext()){
            Map.Entry entry = (Map.Entry)iterator2.next();
            System.out.println("key:"+entry.getKey()+";  value:"+entry.getValue());
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println("key:"+entry.getKey()+";  value:"+entry.getValue());
        }


    }
}

//    使用 entrySet 遍历 Map 类集合 KV，而不是 keySet 方式进行遍历。
//        说明：keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key
//        所对应的 value。而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更
//        高。如果是 JDK8，可以语法更简单的 foreach 方法。