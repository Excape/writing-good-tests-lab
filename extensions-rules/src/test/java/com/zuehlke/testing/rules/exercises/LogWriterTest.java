package com.zuehlke.testing.rules.exercises;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LogWriterTest {

    private LogWriter logWriter = new LogWriter();

    @Test
    void log_toTempFile(@TempDir Path tempDir) throws IOException {
        Path logFilePath = tempDir.resolve("logFile.txt");
        File tempFile = new File(logFilePath.toUri());

        String logMessage = "Some test log message";
        logWriter.log(tempFile, logMessage);

        System.out.println(tempFile.getAbsolutePath());

        assertThat(tempFile.exists(), is(true));
        assertThat(tempFile.canRead(), is(true));

        String result = new String(Files.readAllBytes(logFilePath));
        assertThat(result, equalTo(logMessage));
    }
}