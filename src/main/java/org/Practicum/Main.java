package org.Practicum;

import org.Practicum.subframe.Property;

import java.util.concurrent.Flow;

public class Main {
    public static void main(String[] args) {
        String s=Property.getProperty("url");
        System.out.println(s);
    }
}