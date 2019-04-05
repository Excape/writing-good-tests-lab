package com.zuehlke.testing.hamcrest.exercises;

import com.zuehlke.testing.hamcrest.Person;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


class PersonTest {
    private Person peter = new Person(1, "Peter", "Maler", 42);

    @Test
    void testFields() {
        assertThat(peter, allOf(
                hasProperty("id"),
                isA(Person.class)
                )
        );
    }
}
