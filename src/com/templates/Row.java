package com.templates;

public class Row {
    private static String NAME;
    private static int AGE;

    public Row(String name, int age) {
        NAME = name;
        AGE = age;
    }

    public String getNAME() {
        return NAME;
    }

    public int getAGE() {
        return AGE;
    }

    public static Row getRow() {
        return new Row(NAME, AGE);
    }
}
