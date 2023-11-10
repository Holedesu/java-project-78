package org.example.rules;

import java.util.Map;

public class ContainsRule implements ValidationRules {
    private String substring;

    public ContainsRule(String substring) {
        this.substring = substring;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.contains(substring);
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
