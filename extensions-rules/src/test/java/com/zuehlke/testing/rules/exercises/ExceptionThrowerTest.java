package com.zuehlke.testing.rules.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(LoggerExtension.class)
class ExceptionThrowerTest {

    private ExceptionThrower exceptionThrower = new ExceptionThrower();

    @Test
    void lessThan0_throwRuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> exceptionThrower.throwRuntimeException(-1));

        assertThat(thrown.getMessage(), containsString("Illegal argument"));
    }

    @Test
    void throwExceptionWithCause() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> exceptionThrower.throwExceptionWithCause());

        assertThat(thrown.getCause(), isA(NullPointerException.class));
    }
}