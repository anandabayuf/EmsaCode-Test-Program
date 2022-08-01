package com.emsacode.testproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Iteration Example
 * @author Ananda Bayu
 */
public class IterationExample {
    public static void main(String[] args) {
    	ArrayList<String> hobbies = new ArrayList<String>();
        
        //menambahkan hobi ke dalam hobbies
        hobbies.add("bermain gitar");
        hobbies.add("jogging");
        hobbies.add("berenang");
        hobbies.add("bermain basket");
        
        //iteration for loop
        for(int i = 0; i < hobbies.size(); i++){
            System.out.println(hobbies.get(i));
        }
        
        System.out.println("=====");
        
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        
        System.out.println("=====");
        
        //iteration while loop
        int iteration = 0;
        
        while(iteration < hobbies.size()){
            System.out.println(hobbies.get(iteration));
            iteration++;
        }
        
        System.out.println("=====");
        
        //iteration do while loop
        iteration = 0;
        
        do{
            System.out.println(hobbies.get(iteration));
            iteration++;
        }while(iteration < hobbies.size());
        
        System.out.println("=====");
        
        //iteration using iterator
        Iterator<String> iterator = hobbies.iterator();
        
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        System.out.println("=====");
        
        //remove element using iterator
        iterator = hobbies.iterator();
        
        while(iterator.hasNext()){
            String it = iterator.next();
            if(it == "bermain gitar"){
                iterator.remove();
            }
        }
        
        System.out.println(hobbies);
    }
}
