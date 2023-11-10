package org.example.rules;

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
}
