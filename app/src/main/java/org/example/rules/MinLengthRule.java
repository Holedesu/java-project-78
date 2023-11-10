package org.example.rules;

public class MinLengthRule implements ValidationRules {
    private final int minLength;

    public MinLengthRule(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() >= minLength;
    }

    @Override
    public boolean isValid(Integer value) {
        return false;
    }
}
