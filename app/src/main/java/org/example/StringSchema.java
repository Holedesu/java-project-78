package org.example;


public class StringSchema extends BaseSchema<String> {

    protected boolean required = false;
    private Integer minLength;
    private String contains;

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int minLengthValue) {
        this.minLength = minLengthValue;
        return this;
    }

    public StringSchema contains(String subString) {
        this.contains = subString;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        if (value == null && !required) {
            return true;
        }

        if (value == null || !(value instanceof String)) {
            return false;
        }

        if (required && ((String) value).isEmpty()) {
            return false;
        }

        if (minLength != null && ((String) value).length() < minLength) {
            return false;
        }

        if (contains != null && !((String) value).contains(contains)) {
            return false;
        }

        return true;
    }
}
