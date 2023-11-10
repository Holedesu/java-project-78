import org.example.NumberSchema;
import org.example.StringSchema;
import org.example.MapSchema;
import org.example.Validator;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public final class Tests {

    @Test
    public void testStringValid() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(5)).isFalse();

        schema.minLength(5);
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("whatthe")).isTrue();
        assertThat(schema.isValid("wha")).isFalse();


        schema.isValid("what does the fox say"); // false
    }

    @Test
    public void testStringHain() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("what");
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexletXXXXXXX")).isFalse();
    }

    @Test
    public void testNumberValid() {
        Validator v = new Validator();
        NumberSchema schema = v.number();

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(-5)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();

        schema.positive();
        assertThat(schema.isValid(-5)).isFalse();
        schema.positive();
        assertThat(schema.isValid(0)).isTrue();
        assertThat(schema.isValid(5)).isTrue();

        schema.range(5, 10);
        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(15)).isFalse();
    }
    @Test
    public void testIntegerChain() {
        Validator v = new Validator();
        NumberSchema schema = v.number().positive().required().range(5, 10);

        assertThat(schema.isValid(5)).isTrue();
        assertThat(schema.isValid(-5)).isFalse();
        assertThat(schema.isValid(15)).isFalse();


    }

    @Test
    public void testMapValid() {
        Validator v = new Validator();
        MapSchema schema = v.map();
        assertThat(schema.isValid(null)).isTrue();
        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");

        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);

        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
        data.put("key3", "value3");
        assertThat(schema.isValid(data)).isFalse();
    }

    @Test
    public void testMapChain() {
        Validator v = new Validator();
        MapSchema schema = v.map().required().sizeof(2);
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
        data.put("key3", "value3");
        assertThat(schema.isValid(data)).isFalse();
    }
}
