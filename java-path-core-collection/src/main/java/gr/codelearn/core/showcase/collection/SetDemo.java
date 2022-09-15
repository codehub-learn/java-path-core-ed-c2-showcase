package gr.codelearn.core.showcase.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        SetDemo setDemo = new SetDemo();
        setDemo.createSets();
        setDemo.createTreeSet();
    }

    public void createSets() {
        System.out.println("*************** Create Set examples ***************");
        Set<String> strSet = new HashSet();
        strSet.add("one");
        strSet.add("two");
        strSet.add("three");
        strSet.add("four");
        strSet.add("five");
        strSet.add("five");

        Iterator<String> iterator = strSet.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }

        for (String item : strSet) {
            System.out.println(item);
        }

        System.out.println("Does the Set contain the value three: " + (strSet.contains("three") ? "yes" : "no"));
        System.out.println("Does the Set contain the value seven: " + (strSet.contains("seven") ? "yes" : "no"));
    }

    public void createTreeSet() {
        System.out.println("*************** Create Tree Set examples ***************");
        TreeSet<String> treeSet = new TreeSet(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    return 0;
            }
            
        });
        treeSet.addAll(Set.of(
                "Athens", "Thessaloniki", "Patra", "Hrakleio", "Florina", "Komotini", "Giannena", "Kalymnos", "Xanthi","To be removed"
        ));
        for (String strItem : treeSet) {
            System.out.println("The city is: " + strItem);
        }

        System.out.println("The first city is: " + treeSet.first() + " and the last city is: " + treeSet.last());
        treeSet.remove("To be removed");
        treeSet.pollFirst();
        
        System.out.println("After poll and remove operations");
        for (String strItem : treeSet) {
            System.out.println("The city is: " + strItem);
        }
    }
    
    class StringLengthComparator implements Comparator<String>{
        @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length())
                    return 1;
                else if(o1.length() < o2.length())
                    return -1;
                else
                    return 0;
            }  
    }
}