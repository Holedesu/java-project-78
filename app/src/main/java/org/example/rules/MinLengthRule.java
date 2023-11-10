package org.example.rules;

import java.util.Map;

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

    @Override
    public boolean isValid(Map<?, ?> value) {
        return false;
    }
}
