package org.example;


import org.example.rules.BaseSchema;
import org.example.rules.PositiveRule;
import org.example.rules.RangeRule;
import org.example.rules.ValidationRules;

import java.util.ArrayList;
import java.util.List;

public class NumberSchema {
    private final List<ValidationRules> rules;
    public NumberSchema() {
        rules = new ArrayList<>();
    }

    public NumberSchema required() {
        rules.add(new BaseSchema());
        return this;
    }

    public NumberSchema positive() {
        rules.add(new PositiveRule());
        return this;
    }

    public NumberSchema range(int rangeMin, int rangeMax) {
        rules.add(new RangeRule(rangeMin, rangeMax));
        return this;
    }

    public boolean isValid(Integer value) {
        for (ValidationRules rule : rules) {
            if (!rule.isValid(value)) {
                return false;
            }
        }
        return true;
    }
}
