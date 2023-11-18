import hexlet.code.Validator;
import hexlet.code.BaseSchema;
import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;
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

    @Test
    public void testMapShapeMethod() {
        Validator v = new Validator();

        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();

        // Определяем схемы валидации для значений свойств "name" и "age"
        // Имя должно быть строкой, обязательно для заполнения
        schemas.put("name", v.string().required());
        // Возраст должен быть положительным числом
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 100);
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        assertThat(schema.isValid(human2)).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        assertThat(schema.isValid(human3)).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human4.put("name", "Valya");
        human4.put("age", -5);
        assertThat(schema.isValid(human4)).isFalse();
    }
}
