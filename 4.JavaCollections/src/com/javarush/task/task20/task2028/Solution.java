package com.javarush.task.task20.task2028;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {

        CustomTree tree = new CustomTree();
        tree.add("1");
        tree.add("2");
        tree.add("3");
        tree.add("4");
        tree.add("5");
        tree.add("6");
        tree.add("7");


//        Map<String, String> hm = new HashMap<>();
//        hm.put("0", "zero");
//        hm.put("1", "one");
//        hm.put("2", "three");
//        hm.put("3", "three");
//        hm.put("4", "five");


//        Iterator it = hm.entrySet().iterator();
//        while (it.hasNext()) {
//            Map.Entry pair = (Map.Entry) it.next();
////            System.out.println(pair.getKey() + " = " + pair.getValue());
//            if (pair.getValue().equals(((Map.Entry<?, ?>) it.next()).getValue())) {
//                //System.out.println(pair.getKey() + " " + pair.getValue());
//                it.remove();
//            }
////            it.remove(); // avoids a ConcurrentModificationException
//        }

//        Map<String, String> copy = new HashMap<String, String>(hm);
//        Map<String, String> copy1 = new HashMap<String, String>(hm);
//
//        for (Map.Entry<String, String> e : copy.entrySet()) {
//            int i = 0;
//            for (Map.Entry<String, String> e1 : copy.entrySet()) {
//                if (e1.getValue().equals(e.getValue())) i++;
//                if (i > 1) deleteElement(hm, e.getValue());
//            }
//        }
//        System.out.println("hm:\n" + hm);
//
//
//        for (Map.Entry<String, String> e : copy.entrySet()) {
//            if (Collections.frequency(copy.values(), e.getValue()) > 1) copy1.remove(e.getKey());
//        }
//        System.out.println("copy1:\n" + copy1);


        System.out.println("Size of tree: " + tree.size());
        System.out.println("parent of 6: "+ tree.getParent("6"));
        System.out.println("parent of 5: "+ tree.getParent("5"));
        System.out.println("parent of 4: "+ tree.getParent("4"));
        System.out.println("parent of 3: "+ tree.getParent("3"));
        System.out.println("parent of 7: "+ tree.getParent("7"));


//        tree.print(tree.root);

//        List<String> list = new CustomTree();
//        for (int i = 1; i < 16; i++) {
//            list.add(String.valueOf(i));
//        }
//
//        System.out.println("The list size is " + list.size());
//        System.out.println("The expected parent is 3. The actual parent is " + ((CustomTree) list).getParent("8"));
//        System.out.println("The expected parent is null. The actual parent is " + ((CustomTree) list).getParent("20"));
    }

    //    public static void remove(Set<Integer> set) {
//        set.removeIf(i -> i > 3);
////        set.forEach(System.out::println);
//    }
//    public static void deleteElement(Map<String, String> map, String value) {
//        Map<String, String> copy = new HashMap(map);
//        for (Map.Entry<String, String> entry : copy.entrySet()) {
//            if (entry.getValue().equals(value))
//                map.remove(entry.getKey());
//        }
//    }
}
