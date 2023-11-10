package org.example.rules;

import java.util.Map;

public class PositiveRule implements ValidationRules {

    private final int isPositive;

    public PositiveRule() {
        this.isPositive = 0;
    }
    public boolean isValid(Integer value) {
        return value != null && value >= isPositive;
    }
    @Override
    public boolean isValid(String value) {
        return false;
    }

    @Override
    public boolean isValid(Map<?, ?> value) {
        return false;
    }
}
