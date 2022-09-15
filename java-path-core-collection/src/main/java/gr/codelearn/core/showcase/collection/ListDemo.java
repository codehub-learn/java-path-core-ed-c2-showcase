package gr.codelearn.core.showcase.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        ListDemo listDemo = new ListDemo();
        listDemo.createArrayList();
        listDemo.createLinkedList();
        listDemo.listActions();
    }

    public void createArrayList() {
        System.out.println("*************** Default Array List examples ***************");
        List<String> strList = Arrays.asList("Linus", "Torvalds");
        strList.set(1, "Tech Tips");
        for (String str : strList) {
            System.out.println(str);
        }

        List<String> anotherList = new ArrayList();
        anotherList.add("Ironman");
        anotherList.add("Hulk");
        anotherList.add("Thor");
        anotherList.forEach(System.out::println);

        List<String> listUnmodifiable = List.copyOf(anotherList);
        //It generates an exception
        //listUnmodifiable.add("Something");
        List<String> listModifiable = List.of("Mike", "Giannis");
        //It generates an exception
        //listModifiable.add("Something");
    }
    
    public void createLinkedList(){
        System.out.println("*************** Default Linked List examples ***************");
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("a");
        linkedList.add("c");
        linkedList.addFirst("d");
        linkedList.add(1,"b");
        System.out.println(linkedList);
        linkedList.remove("d");
        linkedList.removeLast();
        System.out.println(linkedList);
        linkedList.clear();
        
        linkedList.addAll(List.of("one","two","three","four"));
        System.out.println("Linked list items: "+ linkedList);
        System.out.println("Peek item: "+ linkedList.peek());
        System.out.println("Linked list items: "+ linkedList);
        System.out.println("Poll item: "+ linkedList.poll());
        System.out.println("Linked list items: "+ linkedList);
        System.out.println("Pop item: "+ linkedList.pop());
        System.out.println("Linked list items: "+ linkedList);
        linkedList.offer("ten");
        linkedList.offerFirst("ena");
        System.out.println("Linked list items: "+ linkedList);
    }
    
    public void listActions(){
        System.out.println("*************** List actions examples ***************");
        List<String> products = createList();
        products.sort(null);
        products.forEach(System.out::println);
        
        List<String> products2 = createList();
        products2.sort((s1,s2)->s1.compareToIgnoreCase(s2));
        products2.forEach(System.out::println);
        products2.removeIf(s->s.toLowerCase().contains("h"));
        products2.forEach(System.out::println);
        
    }
    
    
    private List<String> createList(){
        List<String> someList = new ArrayList();
        someList.addAll(Arrays.asList("Galaxy S100","Sony Headphones MX-Something","DJI Mavic Air","Nvidia RTX 4080"));
        return someList;
    }
}
