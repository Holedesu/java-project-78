package org.example.rules;

public class MinLengthRule implements ValidationRules {
    private int minLength;

    public MinLengthRule(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() >= minLength;
    }
}
