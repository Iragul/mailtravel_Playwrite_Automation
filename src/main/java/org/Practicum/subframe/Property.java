package org.Practicum.subframe;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Property {
    static Properties props = new Properties();


    static String strValue;
    public static String filepath()
    {
        String filpath = Thread.currentThread().getContextClassLoader().getResource("ObjectRepository").getPath();
        System.out.println("Driver Path: " + filpath); // Add this line for debugging

        return filpath;
    }
    static String strFileName= System.getProperty("user.dir")+"\\src\\main\\resources\\Data\\ObjectRepository";
    public Property(){

    }
    public Property(String strFileName) {
        Property.strFileName = strFileName;
    }


    public static String getProperty(String strKey) {
        try {

            File f = new File(strFileName);
            if (f.exists()) {
                FileInputStream in = new FileInputStream(f);
                props.load(in);
                strValue = props.getProperty(strKey);
                in.close();
            } else

                System.out.println("File not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
        return strValue;
    }

    public static void setProperty(String strKey, String strValue) throws Throwable {
        try {
            File f = new File(strFileName);
            if (f.exists()) {
                FileInputStream in = new FileInputStream(f);
                props.load(in);
                props.setProperty(strKey, strValue);
                props.store(new FileOutputStream(strFileName), null);
                in.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void removeProperty(String strKey) {
        try {
            File f = new File(strFileName);
            if (f.exists()) {
                FileInputStream in = new FileInputStream(f);
                props.load(in);
                props.remove(strKey);
                props.store(new FileOutputStream(strFileName), null);
                in.close();
            } else
                System.out.println("File not found!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
