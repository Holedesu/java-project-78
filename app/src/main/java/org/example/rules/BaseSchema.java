package org.example.rules;

import java.util.Map;

public class BaseSchema implements ValidationRules {
    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }

    public boolean isValid(Integer value) {
        return value != null;
    }
    public boolean isValid(Map<?, ?> value) {
        return value != null;

    }
}
