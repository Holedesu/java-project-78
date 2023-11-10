package org.example.rules;

public class PositiveRule implements ValidationRules {

    private final int IS_POSITIVE;

    public PositiveRule() {
        this.IS_POSITIVE = 0;
    }
    public boolean isValid(Integer value) {
        return value != null && value >= IS_POSITIVE;
    }
    @Override
    public boolean isValid(String value) {
        return false;
    }
}
