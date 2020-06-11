package com.example.fragmentsapp;

public enum Level {
    UNDEFINED("undefined"),
    LOW("1"),
    MEDIUM("2"),
    HIGH("3");

    Level(String value) {
        this.value = value;
    }

    private String value;

    public String getValue() {
        return value;
    }
}
