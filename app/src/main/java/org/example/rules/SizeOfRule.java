package org.example.rules;

import java.util.Map;

public class SizeOfRule implements ValidationRules {
    private final int size;
    public SizeOfRule(int value) {
        this.size = value;
    }

    public boolean isValid(String value) {
        return false;
    }
    public boolean isValid(Integer value) {
        return false;
    }
    public boolean isValid(Map<?, ?> value) {
        return value != null && value.size() == size;
    }
}
