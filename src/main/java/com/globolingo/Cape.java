package com.globolingo;

public class Cape implements Item {

    private File file;

    public File getFile() {
        return this.file;
    }

    @Override
    public String getItemtype() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
