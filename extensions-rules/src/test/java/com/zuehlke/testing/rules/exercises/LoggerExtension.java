package com.zuehlke.testing.rules.exercises;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Method;
import java.util.Optional;

public class LoggerExtension implements BeforeTestExecutionCallback {
    @Override
    public void beforeTestExecution(ExtensionContext context) {

        String testClassName = context.getTestClass()
                .map(Class::getCanonicalName)
                .orElse("Unknown class");

        String testMethodName = context.getTestMethod()
                .map(Method::getName)
                .orElse("Unknown method");

        System.out.println(testClassName + ":" + testMethodName);
    }
}
