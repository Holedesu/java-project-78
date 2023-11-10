package org.example.rules;
public class RequiredRules implements ValidationRules {
    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
}
