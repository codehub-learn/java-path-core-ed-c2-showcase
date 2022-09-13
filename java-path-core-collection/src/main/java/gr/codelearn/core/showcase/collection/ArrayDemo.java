/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.collection;

import java.util.Arrays;

/**
 *
 * @author giannis
 */
public class ArrayDemo {

    public static void main(String[] args) {
        ArrayDemo arrayDemo = new ArrayDemo();
        arrayDemo.defaultValues();
        arrayDemo.integerArrays();
    }

    public void defaultValues() {
        System.out.println("*************** Default array examples ***************");
        int[] integerArray = new int[3];
        for (int i = 0; i < integerArray.length; i++) {
            System.out.println(integerArray[i]);
            integerArray[i] = i;
        }

        var stringArray = new String[5];
        StringBuilder stringBuilder = new StringBuilder();
        for (int val : integerArray) {
            stringBuilder.append(val).append(" - ");
        }
        for (String strItem : stringArray) {
            strItem = stringBuilder.toString();
            System.out.println(strItem);
        }
    }

    public void integerArrays() {
        int[] intArray = new int[]{1, 2, 3, 4};
        int[] intArrayTheNewWay = {1, 2, 3, 4};
        
        System.out.println("*************** Initiliazation array examples ***************");
        var logger = new StringBuilder();
        System.out.println("The length of intArrayTheNewWay is: " + intArrayTheNewWay.length);
        for (int i = 0; i < intArrayTheNewWay.length; i++) {
            logger.append(intArrayTheNewWay[i]).append(" ");
        }
        System.out.println(logger);
        
        System.out.println("*************** 2 dimmensional array examples ***************");
        int[][] intArray2D = {{1,3,5,7,9},{0,2,4,6,8}, {1,2,2,3,3,5,5,6,6,7}};
        var logger2D = new StringBuilder();
        for(int i = 0; i < intArray2D.length; i++){
            logger2D.append(" | ");
            for(int j = 0; j < intArray2D[i].length; j++){
                logger2D.append(intArray2D[i][j]).append(" ");
            }
        }
        
        System.out.println(logger2D);
        
        
        System.out.println("*************** Clone array examples ***************");
        int[] cloneArray = intArray.clone();
        int[] coppiedArray = Arrays.copyOf(intArray, intArray.length);
        intArray[1]=15;
        
        for(int i = 0; i < intArray.length; i++){
            System.out.println("Intarray value: "+intArray[i]+" | cloneArray value: "+cloneArray[i]);
        }
      
        
         for(int i = 0; i < intArray.length; i++){
            System.out.println("Intarray value: "+intArray[i]+" | coppied value: "+coppiedArray[i]);
        }
        
        String identicalArrays = intArray == cloneArray ? "identical" : "different";
        System.out.println("Are the arrays identical: "+ identicalArrays);
        System.out.println("Are the arrays equal: "+ Arrays.equals(intArray, cloneArray));
    }

}
