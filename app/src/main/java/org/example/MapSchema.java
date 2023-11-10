package org.example;


import org.example.rules.BaseSchema;

import org.example.rules.SizeOfRule;
import org.example.rules.ValidationRules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapSchema {
    private final List<ValidationRules> rules;
    public MapSchema() {
        rules = new ArrayList<>();
    }

    public MapSchema required() {
        rules.add(new BaseSchema());
        return this;
    }

    public MapSchema sizeof(int size) {
        rules.add(new SizeOfRule(size));
        return this;
    }



    public boolean isValid(Map<?, ?> value) {
        for (ValidationRules rule : rules) {
            if (!rule.isValid(value)) {
                return false;
            }
        }
        return true;
    }
}

