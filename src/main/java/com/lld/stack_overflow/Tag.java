package com.lld.stack_overflow;

public class Tag {
    private final int id;
    private final String name;

    public Tag(String name) {
        this.id = generateId();
        this.name = name;
    }

    private int generateId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    ////////////
    public int getId() { return id; }
    public String getName() { return name; }
}
