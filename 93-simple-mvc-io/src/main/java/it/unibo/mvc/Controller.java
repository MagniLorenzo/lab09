package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_FILE = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File actualFile;

    public Controller() {
        this.actualFile = new File(DEFAULT_FILE);
    }

    public void setFile(final File file) {
        this.actualFile = file;
    }

    public File getFile() {
        return this.actualFile;
    }

    public String getFilePath() {
        return this.actualFile.getAbsolutePath();
    }

    public void saveOnFile(final String str) throws IOException {
        try (final PrintStream ps = new PrintStream(actualFile, StandardCharsets.UTF_8)) {
            ps.println(str);
        }
    }
}
