
package gr.codelearn.core.showcase.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericsExample {
    public static void main(String[] args) {
        GenericsExample genericsExample = new GenericsExample();
        genericsExample.typeSafetyExample();
        genericsExample.upperBoundExample();
    }
    
    public void typeSafetyExample(){
        System.out.println("*************** TypeSafety examples ***************");
        List listError = new ArrayList();
        listError.add("abc");
        listError.add(5);
        
        for(Object object:listError){
            //Runtime error if uncommented
            //String str = (String) object;
            //System.out.println("The string value is: "+ str);
        }
        
        List<String> listGeneric = new ArrayList<>();
        listGeneric.add("a");
        listGeneric.add("b");
        //Compile-time error
        //listGeneric.add(5);
    }
    
    public void upperBoundExample(){
        System.out.println("*************** Upper Bound examples ***************");
        List<Integer> integerList = new ArrayList();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        System.out.println("The mean of Integer list is: "+calculateMean(integerList));
        List<Double> doubleList = new ArrayList();
        doubleList.add(12.5);
        doubleList.add(15.5);
        doubleList.add(5.5);
        System.out.println("The mean of Double list is: "+calculateMean(doubleList));
        //List<String> stringList = new ArrayList();
        //System.out.println("The mean of Double list is: "+calculateMean(stringList));
    }
    
    private double calculateMean(List<? extends Number> numbers){
        if(!numbers.isEmpty()){
            return numbers.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
        }
        else
            return 0;
    }
    
    public void lowerBound(){
        List<Integer> integerList = new ArrayList();
        integerList.add(5);
        integerList.add(10);
        integerList.add(15);
        List<Double> doubleList = new ArrayList();
        doubleList.add(12.5);
        doubleList.add(15.5);
        doubleList.add(5.5);
        List<Number> numberList = new ArrayList();
        numberList.add(5);
        List<? super Integer> lowerBoundList;
        lowerBoundList = integerList;
        lowerBoundList = numberList;
        //Compile-time error
        //lowerBoundList = doubleList;
    }
}
