package org.example.rules;

public class ContainsRule implements ValidationRules {
    private String substring;

    public ContainsRule(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.contains(substring);
    }
}
