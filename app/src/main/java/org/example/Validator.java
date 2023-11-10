package org.example;

public class Validator {
    String string;
    int number;

    public StringSchema string() {
        return new StringSchema();
    }

    public NumberSchema number() {
        return new NumberSchema();
    }
}
