package com.javarush.task.task31.task3109;

import javax.script.ScriptException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.zip.ZipOutputStream;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) throws ScriptException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);

//        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("sdf"), StandardCharsets.UTF_8);
//        FileInputStream fos = new FileOutputStream("sdf");

//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("JavaScript");
//        engine.eval("alert('1')"); // Noncompliant
    }

    public Properties getProperties(String fileName) {
        File prop = new File(fileName);
        Properties properties = new Properties();
        try {
            if (fileName.endsWith(".xml"))
                properties.loadFromXML(new FileInputStream(prop));
            else properties.load(new FileReader(prop));
            return properties;
        } catch (IOException e) {
            //e.printStackTrace();
            return properties;
        }
    }
}
