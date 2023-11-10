package org.example.rules;

import java.util.Map;

public class RangeRule implements ValidationRules {

    private final int minRange;
    private final int maxRange;

    public RangeRule(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
    }
    public boolean isValid(Integer value) {
        return value != null && (value >= minRange && value <= maxRange);
    }

    @Override
    public boolean isValid(String value) {
        return value != null;
    }

    @Override
    public boolean isValid(Map<?, ?> value) {
        return false;
    }
}
