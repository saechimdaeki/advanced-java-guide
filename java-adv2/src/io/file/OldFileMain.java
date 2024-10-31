package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {

    public static void main(String[] args) throws IOException {
        final File file = new File("temp/example.txt");
        final File directory = new File("temp/exampleDir");

        System.out.println("File exists: " + file.exists());

        final boolean created = file.createNewFile();
        System.out.println("File created: " + created);

        final boolean dirCreated = directory.mkdir();
        System.out.println("Directory created: " + dirCreated);

//        boolean deleted = file.delete();
//        System.out.println("File deleted: " + deleted);

        System.out.println("Is file: " + file.isFile());
        System.out.println("Is directory: " + file.isDirectory());
        System.out.println("File Name: " + file.getName());
        System.out.println("File size: " + file.length() + " bytes");

        final File newFile = new File("temp/newExample.txt");
        final boolean renamed = file.renameTo(newFile);
        System.out.println("File renamed: " + renamed);

        final long lastModified = newFile.lastModified();
        System.out.println("Last modified: " + new Date(lastModified));
    }
}
