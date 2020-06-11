package com.example.myapplication;

public enum Type {
    UNDEFINED("undefined"),
    THEORY("theory"),
    PRACTICE("practice");

    Type(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
