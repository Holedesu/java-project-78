package org.example;

import org.example.rules.ContainsRule;
import org.example.rules.MinLengthRule;
import org.example.rules.RequiredRules;
import org.example.rules.ValidationRules;


import java.util.ArrayList;
import java.util.List;


public class StringSchema {
    public final List<ValidationRules> rules;

    public StringSchema() {
        rules = new ArrayList<>();
    }

    public StringSchema required() {
        rules.add(new RequiredRules());
        return this;
    }

    public StringSchema minLength(int minLength) {
        rules.add(new MinLengthRule(minLength));
        return this;
    }

    public StringSchema contains(String substring) {
        rules.add(new ContainsRule(substring));
        return this;
    }

    public boolean isValid(String value) {
        for (ValidationRules rule : rules) {
            if (!rule.isValid(value)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(int value) {
        return false;
    }

}
