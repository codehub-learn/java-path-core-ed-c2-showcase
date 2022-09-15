package gr.codelearn.core.showcase.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        MapDemo mapDemo = new MapDemo();
        mapDemo.createMap();
    }

    public void createMap() {
        System.out.println("*************** Create Map examples ***************");
        Map<String, String> mapStringToString = Map.of("key1", "value1", "key2", "value2");
        System.out.println(mapStringToString);

        Map<String, Integer> mapStringToInteger = new HashMap();
        mapStringToInteger.put("Milk", 2);
        mapStringToInteger.put("Water", 10);
        mapStringToInteger.put("Tsixla", 1);
        mapStringToInteger.put("Portokali", 5);
        System.out.println("Print both keys and values: " + mapStringToInteger);
        System.out.println("Print both keys: " + mapStringToInteger.keySet());
        System.out.println("Print both values: " + mapStringToInteger.values());
        System.out.println("Get the value for key Milk: " + mapStringToInteger.get("Milk"));
        mapStringToInteger.put("Milk", 12);
        System.out.println("Get the value for key Milk after updating the value: " + mapStringToInteger.get("Milk"));
        System.out.println("For each loop");
        mapStringToInteger.forEach((k, v) -> System.out.println("The key is: " + k + " the value is: " + v));
    }
}
