package com.peaksoft;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Files {
    static void writeFile(String object, Path path) {
        try {
            java.nio.file.Files.writeString(Paths.get(String.valueOf(path)), object,
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static String fileRead(Path path) {
        StringBuilder json = new StringBuilder();
        try (FileReader reader = new FileReader(String.valueOf(path));) {
            int a;
            while ((a = reader.read()) != -1) {
                json.append((char) a);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return json.toString();
    }
}
