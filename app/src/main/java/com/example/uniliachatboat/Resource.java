package com.example.uniliachatboat;

public class Resource {
    private String title;
    private String description;

    public Resource(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}