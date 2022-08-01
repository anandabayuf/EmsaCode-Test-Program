package com.emsacode.testproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Array List Example
 * @author Ananda Bayu
 */
public class ArrayListExample {
    public static void main(String[] args) {
    	ArrayList<String> hobbies = new ArrayList<String>();
        
        //menambahkan hobi ke dalam hobbies
        hobbies.add("bermain gitar");
        hobbies.add("jogging");
        hobbies.add("berenang");
        hobbies.add("bermain basket");
        
        //akses dan print hobi ke-0
        System.out.println(hobbies.get(0));
        
        //ubah hobi ke-0 menjadi bermain piano
        hobbies.set(0, "bermain piano");
        
        //akses dan print hobi ke-0
        System.out.println(hobbies.get(0));
        
        //hapus hobi ke-0
        hobbies.remove(0);
        
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
    }
}
