package org.example.rules;
public class BaseSchema implements ValidationRules {
    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
    public boolean isValid(Integer value) {return value != null;}
}
