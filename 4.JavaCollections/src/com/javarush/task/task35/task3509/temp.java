package com.javarush.task.task35.task3509;

public class temp {
    public static void main(String[] args) {
        String str = "<qwe>qewqweqwe<asd><zxc>c";
        String temp;
        while (str.contains("<") && str.contains(">")) {
            temp = str.substring(str.indexOf("<")+1, str.indexOf(">"));
            str = str.substring(temp.length());
            System.out.println(temp);
        }
    }
}
