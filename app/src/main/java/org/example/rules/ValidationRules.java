package org.example.rules;

import java.util.Map;

public interface ValidationRules {
    boolean isValid(String value);
    boolean isValid(Integer value);

    boolean isValid(Map<?, ?> value);
}
