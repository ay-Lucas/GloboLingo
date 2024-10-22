package com.globolingo;

import java.io.File;

/**
 * @author Alexander Hughes
 * This class is the picture that will be associated with the matching
 * question type
 */
public class Picture {
    
    private File file;
    private String name;

        // Name name should be String name in UML
    public Picture(String name, File file)  {
        setFile(file);
        setName(name);
    }

        // Getters not present in UML
    public File getFile()  { return this.file; }
    
    public String getName()  { return this.name; }

        // Setters not present in UML
    public void setFile(File file) {
        this.file = file;
    }

    public void setName(String name)  {
        this.name = name;
    }
}
