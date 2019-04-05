package com.zuehlke.testing.hamcrest.exercises;

import com.zuehlke.testing.hamcrest.Person;
import org.hamcrest.Description;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

class PersonMatcherTest {

    @Test
    void testPerson_getName_HanSolo() {
        Person han = new Person(1, "Han", "Solo", 30);

        assertThat(han, hasName("Han", "Solo"));
        assertThat(han, hasName("Han", "Skywalker"));

    }

    static Matcher<Person> hasName(String firstName, String lastName) {
        return new TypeSafeDiagnosingMatcher<Person>() {
            @Override
            protected boolean matchesSafely(Person item, Description mismatchDescription) {
                mismatchDescription.appendText(" was ").appendValue(item.getFirstname() + " " + item.getLastname());

                return item.getFirstname().equals(firstName) && item.getLastname().equals(lastName);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Name should be ").appendValue(firstName).appendValue(lastName);
            }
        };
    }
}
