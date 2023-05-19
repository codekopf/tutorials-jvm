package com.codepills.entity;

public class Document {

    private int version;
    private String content;

    public Document(final int version, final String content) {
        this.version = version;
        this.content = content;
    }

    public int getVersion() {
        return this.version;
    }
}
