package hexlet.code.schemas;

public final class NumberSchema extends BaseSchema<Integer> {
    private boolean required = false;
    private boolean positive = false;
    private Integer min;
    private Integer max;


    public NumberSchema required() {
        required = true;
        return this;
    }

    public NumberSchema positive() {
        positive = true;
        return this;
    }

    public NumberSchema range(int minValue, int maxValue) {
        this.min = minValue;
        this.max = maxValue;
        return this;
    }

    @Override
    public boolean isValid(Object value) {
        if (value == null && !required) {
            return true;
        }

        if (value == null || !(value instanceof Integer)) {
            return false;
        }

        if (positive && ((Integer) value) <= 0) {
            return false;
        }

        if ((min) != null && ((Integer) value) < min) {
            return false;
        }

        if ((max) != null  && ((Integer) value) > max) {
            return false;
        }

        return true;
    }
}
