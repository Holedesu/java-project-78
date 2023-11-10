package org.example.rules;

public class RangeRule implements ValidationRules {

    private final int MIN_RANGE;
    private final int MAX_RANGE;

    public RangeRule(int min, int max) {
        this.MIN_RANGE = min;
        this.MAX_RANGE = max;
    }
    public boolean isValid(Integer value) {
        return value != null && (value >= MIN_RANGE && value <= MAX_RANGE);
    }

    @Override
    public boolean isValid(String value) {
        return value != null;
    }
}
