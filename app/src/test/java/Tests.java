import org.example.StringSchema;
import org.example.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public final class Tests {

    @Test
    public void test() {
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
    public void testCHain() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(5).contains("what");
        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("hexletXXXXXXX")).isFalse();
    }
}
