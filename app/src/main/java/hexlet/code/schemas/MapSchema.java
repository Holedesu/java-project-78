package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, ?>> {
    private boolean required = false;
    private Integer size;
    private Map<String, BaseSchema> shapeSchemas;

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int sizeValue) {
        this.size = sizeValue;
        return this;

    }
    @Override
    public boolean isValid(Object value) {
        if (value == null && !required) {
            return true;
        }

        if (value == null || !(value instanceof Map)) {
            return false;
        }

        if (size != null && ((HashMap) value).size() != size) {
            return false;
        }

        if (shapeSchemas != null) {
            for (Map.Entry<String, BaseSchema> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema schema = entry.getValue();

                if (!((Map<String, ?>) value).containsKey(key) || !schema.isValid(((Map<?, ?>) value).get(key))) {
                    return false;
                }
            }
        }

        return true;
    }
}
